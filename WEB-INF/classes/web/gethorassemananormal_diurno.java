package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethorassemananormal_diurno extends GXProcedure
{
   public gethorassemananormal_diurno( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethorassemananormal_diurno.class ), "" );
   }

   public gethorassemananormal_diurno( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           String aP3 )
   {
      gethorassemananormal_diurno.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      gethorassemananormal_diurno.this.AV9CliCod = aP0;
      gethorassemananormal_diurno.this.AV10EmpCod = aP1;
      gethorassemananormal_diurno.this.AV11PaiCod = aP2;
      gethorassemananormal_diurno.this.AV12ConveCodigo = aP3;
      gethorassemananormal_diurno.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LegTipoTra.add("diurno", 0);
      GXv_decimal1[0] = AV13LegHorasSem ;
      new web.gethorassemananormal(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, 0, AV11PaiCod, AV12ConveCodigo, AV8LegTipoTra, GXv_decimal1) ;
      gethorassemananormal_diurno.this.AV13LegHorasSem = GXv_decimal1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))+httpContext.getMessage( " &Legajo.LegPaiCod ", "")+GXutil.trim( GXutil.str( AV11PaiCod, 4, 0))+httpContext.getMessage( " &Legajo.LegConveCodigo ", "")+GXutil.trim( AV12ConveCodigo)+httpContext.getMessage( " &LegTipoTra ", "")+AV8LegTipoTra.toJSonString(false)+httpContext.getMessage( " &LegHorasSem ", "")+GXutil.trim( GXutil.str( AV13LegHorasSem, 4, 1))) ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV13LegHorasSem)==0) )
      {
         AV13LegHorasSem = DecimalUtil.doubleToDec(48) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gethorassemananormal_diurno.this.AV13LegHorasSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LegHorasSem = DecimalUtil.ZERO ;
      AV8LegTipoTra = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV17Pgmname = "" ;
      AV17Pgmname = "getHorasSemanaNormal_Diurno" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getHorasSemanaNormal_Diurno" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV11PaiCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV13LegHorasSem ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV12ConveCodigo ;
   private String AV17Pgmname ;
   private java.math.BigDecimal[] aP4 ;
   private GXSimpleCollection<String> AV8LegTipoTra ;
}

