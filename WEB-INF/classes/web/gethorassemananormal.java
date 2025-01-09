package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethorassemananormal extends GXProcedure
{
   public gethorassemananormal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethorassemananormal.class ), "" );
   }

   public gethorassemananormal( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           String aP4 ,
                                           GXSimpleCollection<String> aP5 )
   {
      gethorassemananormal.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        GXSimpleCollection<String> aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             GXSimpleCollection<String> aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      gethorassemananormal.this.AV13CliCod = aP0;
      gethorassemananormal.this.AV15EmpCod = aP1;
      gethorassemananormal.this.AV14LegNumero = aP2;
      gethorassemananormal.this.AV8PaiCod = aP3;
      gethorassemananormal.this.AV9ConveCodigo = aP4;
      gethorassemananormal.this.AV16LegTipoTra = aP5;
      gethorassemananormal.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV18diurnoEs ;
      GXv_char2[0] = AV19diurnoLegTipoTra ;
      GXv_boolean3[0] = AV20nocturnoEs ;
      GXv_char4[0] = AV21nocturnoLegTipoTra ;
      GXv_boolean5[0] = AV22insalubreEs ;
      GXv_char6[0] = AV23insalubreLegTipoTra ;
      new web.empleadogettipotra(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, AV16LegTipoTra, GXv_boolean1, GXv_char2, GXv_boolean3, GXv_char4, GXv_boolean5, GXv_char6) ;
      gethorassemananormal.this.AV18diurnoEs = GXv_boolean1[0] ;
      gethorassemananormal.this.AV19diurnoLegTipoTra = GXv_char2[0] ;
      gethorassemananormal.this.AV20nocturnoEs = GXv_boolean3[0] ;
      gethorassemananormal.this.AV21nocturnoLegTipoTra = GXv_char4[0] ;
      gethorassemananormal.this.AV22insalubreEs = GXv_boolean5[0] ;
      gethorassemananormal.this.AV23insalubreLegTipoTra = GXv_char6[0] ;
      GXv_char6[0] = AV17PaiTipoTraId ;
      new web.decidirtipodetrabajo(remoteHandle, context).execute( AV18diurnoEs, AV20nocturnoEs, AV22insalubreEs, AV19diurnoLegTipoTra, AV21nocturnoLegTipoTra, AV23insalubreLegTipoTra, GXv_char6) ;
      gethorassemananormal.this.AV17PaiTipoTraId = GXv_char6[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ConveCodigo ", "")+AV9ConveCodigo) ;
      if ( ! (GXutil.strcmp("", AV9ConveCodigo)==0) )
      {
         GXv_decimal7[0] = AV11horasSemanaCompleta ;
         new web.getconvesemhoras(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, AV8PaiCod, AV9ConveCodigo, AV17PaiTipoTraId, GXv_decimal7) ;
         gethorassemananormal.this.AV11horasSemanaCompleta = GXv_decimal7[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&horasSemanaCompleta ", "")+GXutil.trim( GXutil.str( AV11horasSemanaCompleta, 4, 1))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV15EmpCod, 4, 0))+httpContext.getMessage( " &PaiTipoTraId ", "")+AV17PaiTipoTraId) ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11horasSemanaCompleta)==0) )
      {
         GXv_decimal7[0] = AV11horasSemanaCompleta ;
         new web.getempsemhoras(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV17PaiTipoTraId, GXv_decimal7) ;
         gethorassemananormal.this.AV11horasSemanaCompleta = GXv_decimal7[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "por empresa ", "")+GXutil.trim( GXutil.str( AV11horasSemanaCompleta, 4, 1))) ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11horasSemanaCompleta)==0) )
      {
         GXv_decimal7[0] = AV11horasSemanaCompleta ;
         new web.getpaisemhoras(remoteHandle, context).execute( AV8PaiCod, AV17PaiTipoTraId, GXv_decimal7) ;
         gethorassemananormal.this.AV11horasSemanaCompleta = GXv_decimal7[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = gethorassemananormal.this.AV11horasSemanaCompleta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11horasSemanaCompleta = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      AV19diurnoLegTipoTra = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV21nocturnoLegTipoTra = "" ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV23insalubreLegTipoTra = "" ;
      AV17PaiTipoTraId = "" ;
      GXv_char6 = new String[1] ;
      AV26Pgmname = "" ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV26Pgmname = "getHorasSemanaNormal" ;
      /* GeneXus formulas. */
      AV26Pgmname = "getHorasSemanaNormal" ;
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV8PaiCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV11horasSemanaCompleta ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV9ConveCodigo ;
   private String AV19diurnoLegTipoTra ;
   private String GXv_char2[] ;
   private String AV21nocturnoLegTipoTra ;
   private String GXv_char4[] ;
   private String AV23insalubreLegTipoTra ;
   private String AV17PaiTipoTraId ;
   private String GXv_char6[] ;
   private String AV26Pgmname ;
   private boolean AV18diurnoEs ;
   private boolean GXv_boolean1[] ;
   private boolean AV20nocturnoEs ;
   private boolean GXv_boolean3[] ;
   private boolean AV22insalubreEs ;
   private boolean GXv_boolean5[] ;
   private java.math.BigDecimal[] aP6 ;
   private GXSimpleCollection<String> AV16LegTipoTra ;
}

