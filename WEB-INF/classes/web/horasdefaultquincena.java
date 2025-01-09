package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horasdefaultquincena extends GXProcedure
{
   public horasdefaultquincena( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horasdefaultquincena.class ), "" );
   }

   public horasdefaultquincena( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 ,
                                           short aP4 )
   {
      horasdefaultquincena.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        short aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             short aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      horasdefaultquincena.this.AV12Clicod = aP0;
      horasdefaultquincena.this.AV13EmpCod = aP1;
      horasdefaultquincena.this.AV14LegNumero = aP2;
      horasdefaultquincena.this.AV10LiqPeriodo = aP3;
      horasdefaultquincena.this.AV15quincena = aP4;
      horasdefaultquincena.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV8diaDate ;
      GXv_date2[0] = AV9finDate ;
      new web.getperiodoquincena(remoteHandle, context).execute( AV12Clicod, AV15quincena, AV10LiqPeriodo, GXv_date1, GXv_date2) ;
      horasdefaultquincena.this.AV8diaDate = GXv_date1[0] ;
      horasdefaultquincena.this.AV9finDate = GXv_date2[0] ;
      GXv_int3[0] = AV18cantDias ;
      new web.diasenperiodo(remoteHandle, context).execute( AV12Clicod, AV13EmpCod, AV14LegNumero, (short)(0), AV8diaDate, AV9finDate, false, true, GXv_int3) ;
      horasdefaultquincena.this.AV18cantDias = GXv_int3[0] ;
      GXv_decimal4[0] = AV11horasPorDia ;
      new web.gethorasdianormal(remoteHandle, context).execute( AV12Clicod, AV13EmpCod, AV14LegNumero, GXv_decimal4) ;
      horasdefaultquincena.this.AV11horasPorDia = GXv_decimal4[0] ;
      AV16horas = DecimalUtil.doubleToDec(AV18cantDias).multiply(AV11horasPorDia) ;
      GXv_decimal4[0] = AV19LegHorasSem ;
      new web.getleghorassemana(remoteHandle, context).execute( AV12Clicod, AV13EmpCod, AV14LegNumero, GXv_decimal4) ;
      horasdefaultquincena.this.AV19LegHorasSem = GXv_decimal4[0] ;
      AV19LegHorasSem = AV19LegHorasSem.multiply(DecimalUtil.doubleToDec(2)) ;
      if ( DecimalUtil.compareTo(AV16horas, AV19LegHorasSem) > 0 )
      {
         AV16horas = AV19LegHorasSem ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&Clicod: ", "")+GXutil.trim( GXutil.str( AV12Clicod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&quincena: ", "")+GXutil.trim( GXutil.str( AV15quincena, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqPeriodo: ", "")+GXutil.trim( localUtil.dtoc( AV10LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&diaDate: ", "")+GXutil.trim( localUtil.dtoc( AV8diaDate, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&finDate: ", "")+GXutil.trim( localUtil.dtoc( AV9finDate, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV13EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&cantDias: ", "")+GXutil.trim( GXutil.str( AV18cantDias, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&horasPorDia: ", "")+GXutil.trim( GXutil.str( AV11horasPorDia, 3, 1))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&horas: ", "")+GXutil.trim( GXutil.str( AV16horas, 9, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LegHorasSem: ", "")+GXutil.trim( GXutil.str( AV19LegHorasSem, 4, 1))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = horasdefaultquincena.this.AV16horas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16horas = DecimalUtil.ZERO ;
      AV8diaDate = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV9finDate = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_int3 = new short[1] ;
      AV11horasPorDia = DecimalUtil.ZERO ;
      AV19LegHorasSem = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV22Pgmname = "" ;
      AV22Pgmname = "horasDefaultQuincena" ;
      /* GeneXus formulas. */
      AV22Pgmname = "horasDefaultQuincena" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV15quincena ;
   private short AV18cantDias ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV12Clicod ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV16horas ;
   private java.math.BigDecimal AV11horasPorDia ;
   private java.math.BigDecimal AV19LegHorasSem ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV22Pgmname ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date AV8diaDate ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV9finDate ;
   private java.util.Date GXv_date2[] ;
   private java.math.BigDecimal[] aP5 ;
}

