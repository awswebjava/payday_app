package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class alcanza_ganancias extends GXProcedure
{
   public alcanza_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( alcanza_ganancias.class ), "" );
   }

   public alcanza_ganancias( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           int aP5 ,
                           String aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 ,
                           String[] aP9 )
   {
      alcanza_ganancias.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        int aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             int aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      alcanza_ganancias.this.AV11CliCod = aP0;
      alcanza_ganancias.this.AV13EmpCod = aP1;
      alcanza_ganancias.this.AV14LiqNro = aP2;
      alcanza_ganancias.this.AV15LiqRelNro = aP3;
      alcanza_ganancias.this.AV16LiqPeriodo = aP4;
      alcanza_ganancias.this.AV17LegNumero = aP5;
      alcanza_ganancias.this.AV18ProcesoLiquidacion = aP6;
      alcanza_ganancias.this.aP7 = aP7;
      alcanza_ganancias.this.aP8 = aP8;
      alcanza_ganancias.this.aP9 = aP9;
      alcanza_ganancias.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV10auxConCodigo ;
      GXt_char2 = AV10auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      alcanza_ganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
      alcanza_ganancias.this.GXt_char1 = GXv_char4[0] ;
      AV10auxConCodigo = GXt_char1 ;
      GXv_char4[0] = AV9ConDescrip ;
      GXv_boolean5[0] = AV28existe ;
      new web.conceptogetdescri2(remoteHandle, context).execute( AV11CliCod, GXutil.trim( AV10auxConCodigo), GXv_char4, GXv_boolean5) ;
      alcanza_ganancias.this.AV9ConDescrip = GXv_char4[0] ;
      alcanza_ganancias.this.AV28existe = GXv_boolean5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &auxConCodigo ", "")+GXutil.trim( AV10auxConCodigo)+httpContext.getMessage( " &ConDescrip ", "")+GXutil.trim( AV9ConDescrip)+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV28existe))) ;
      if ( ! AV28existe )
      {
         AV20LiqDCalculado = (byte)(0) ;
         AV21Error = httpContext.getMessage( "No existe el concepto \"", "") + GXutil.trim( AV10auxConCodigo) + "\"" ;
         AV8LiqDLog = GXutil.trim( AV21Error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "antes ", "")+GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2))) ;
      GXv_decimal6[0] = AV12auxLiqDImpCalcu ;
      GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
      GXv_boolean5[0] = AV28existe ;
      GXv_int8[0] = AV19auxLiqDCalculado ;
      new web.getliqdimpcalcuporperiodo(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV14LiqNro, AV15LiqRelNro, AV16LiqPeriodo, AV17LegNumero, AV10auxConCodigo, AV18ProcesoLiquidacion, false, false, GXv_decimal6, GXv_decimal7, GXv_boolean5, GXv_int8) ;
      alcanza_ganancias.this.AV12auxLiqDImpCalcu = GXv_decimal6[0] ;
      alcanza_ganancias.this.AV28existe = GXv_boolean5[0] ;
      alcanza_ganancias.this.AV19auxLiqDCalculado = GXv_int8[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "despues ", "")+GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2))) ;
      if ( ( AV19auxLiqDCalculado == 0 ) || ! AV28existe )
      {
         AV20LiqDCalculado = (byte)(0) ;
         if ( ! AV28existe )
         {
            AV21Error = httpContext.getMessage( "No existe ", "") + GXutil.trim( AV10auxConCodigo) + httpContext.getMessage( " en liquidación", "") ;
         }
         else
         {
            AV21Error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9ConDescrip) ;
         }
         AV8LiqDLog = GXutil.trim( AV21Error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "despues2 ", "")+GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &auxConCodigo ", "")+GXutil.trim( AV10auxConCodigo)) ;
      AV8LiqDLog = httpContext.getMessage( "Concepto \"", "") + GXutil.trim( AV9ConDescrip) + httpContext.getMessage( "\" para el periodo es de ", "") + GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2)) ;
      GXt_char2 = AV10auxConCodigo ;
      GXt_char1 = AV10auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_brutopromedio_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      alcanza_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char3) ;
      alcanza_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV10auxConCodigo = GXt_char2 ;
      GXv_char4[0] = AV9ConDescrip ;
      GXv_boolean5[0] = AV28existe ;
      new web.conceptogetdescri2(remoteHandle, context).execute( AV11CliCod, AV10auxConCodigo, GXv_char4, GXv_boolean5) ;
      alcanza_ganancias.this.AV9ConDescrip = GXv_char4[0] ;
      alcanza_ganancias.this.AV28existe = GXv_boolean5[0] ;
      if ( ! AV28existe )
      {
         AV20LiqDCalculado = (byte)(0) ;
         AV21Error = httpContext.getMessage( "No existe el concepto \"", "") + GXutil.trim( AV10auxConCodigo) + "\"" ;
         AV8LiqDLog = GXutil.trim( AV21Error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_decimal7[0] = AV23aux2LiqDImpCalcu ;
      GXv_boolean5[0] = AV28existe ;
      GXv_int8[0] = AV19auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV14LiqNro, AV17LegNumero, AV10auxConCodigo, AV18ProcesoLiquidacion, false, GXv_decimal7, GXv_boolean5, GXv_int8) ;
      alcanza_ganancias.this.AV23aux2LiqDImpCalcu = GXv_decimal7[0] ;
      alcanza_ganancias.this.AV28existe = GXv_boolean5[0] ;
      alcanza_ganancias.this.AV19auxLiqDCalculado = GXv_int8[0] ;
      if ( ( AV19auxLiqDCalculado == 0 ) || ! AV28existe )
      {
         AV20LiqDCalculado = (byte)(0) ;
         if ( ! AV28existe )
         {
            AV21Error = httpContext.getMessage( "No existe ", "") + GXutil.trim( AV10auxConCodigo) + httpContext.getMessage( " en liquidación", "") ;
         }
         else
         {
            AV21Error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9ConDescrip) ;
         }
         AV8LiqDLog = GXutil.trim( AV21Error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8LiqDLog += httpContext.getMessage( ". Concepto \"", "") + GXutil.trim( AV9ConDescrip) + httpContext.getMessage( "\" para la liquidación es de ", "") + GXutil.trim( GXutil.str( AV23aux2LiqDImpCalcu, 14, 2)) ;
      if ( DecimalUtil.compareTo(AV23aux2LiqDImpCalcu, AV12auxLiqDImpCalcu) < 0 )
      {
         AV22menorLiqDImpCalcu = AV23aux2LiqDImpCalcu ;
      }
      else
      {
         AV22menorLiqDImpCalcu = AV12auxLiqDImpCalcu ;
      }
      GXv_char4[0] = AV25OpeCliValor ;
      GXv_char3[0] = AV29auxLiqDLog ;
      GXv_char9[0] = AV26auxError ;
      new web.getmnisegunestadocivilehijos(remoteHandle, context).execute( AV11CliCod, AV13EmpCod, AV17LegNumero, AV16LiqPeriodo, AV18ProcesoLiquidacion, true, GXv_char4, GXv_char3, GXv_char9) ;
      alcanza_ganancias.this.AV25OpeCliValor = GXv_char4[0] ;
      alcanza_ganancias.this.AV29auxLiqDLog = GXv_char3[0] ;
      alcanza_ganancias.this.AV26auxError = GXv_char9[0] ;
      if ( ! (GXutil.strcmp("", AV26auxError)==0) )
      {
         AV21Error = GXutil.trim( AV26auxError) ;
         AV8LiqDLog = GXutil.trim( AV21Error) ;
         AV20LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8LiqDLog += ". " + GXutil.trim( AV29auxLiqDLog) ;
      AV12auxLiqDImpCalcu = CommonUtil.decimalVal( AV25OpeCliValor, ".") ;
      if ( DecimalUtil.compareTo(AV22menorLiqDImpCalcu, AV12auxLiqDImpCalcu) > 0 )
      {
         AV8LiqDLog += httpContext.getMessage( ". El empleado es alcanzado por el impuesto al ser la remuneración ", "") + GXutil.trim( GXutil.str( AV22menorLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " mayor al piso ", "") + GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2)) ;
         AV27Importes = DecimalUtil.doubleToDec(1) ;
      }
      else
      {
         AV8LiqDLog += httpContext.getMessage( ". El empleado no es alcanzado por el impuesto al ser la remuneración ", "") + GXutil.trim( GXutil.str( AV22menorLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " menor o igual  al piso ", "") + GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = alcanza_ganancias.this.AV27Importes;
      this.aP8[0] = alcanza_ganancias.this.AV8LiqDLog;
      this.aP9[0] = alcanza_ganancias.this.AV21Error;
      this.aP10[0] = alcanza_ganancias.this.AV20LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27Importes = DecimalUtil.ZERO ;
      AV8LiqDLog = "" ;
      AV21Error = "" ;
      AV10auxConCodigo = "" ;
      AV9ConDescrip = "" ;
      AV32Pgmname = "" ;
      AV12auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      AV23aux2LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_int8 = new byte[1] ;
      AV22menorLiqDImpCalcu = DecimalUtil.ZERO ;
      AV25OpeCliValor = "" ;
      GXv_char4 = new String[1] ;
      AV29auxLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      AV26auxError = "" ;
      GXv_char9 = new String[1] ;
      AV32Pgmname = "alcanza_ganancias" ;
      /* GeneXus formulas. */
      AV32Pgmname = "alcanza_ganancias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqDCalculado ;
   private byte AV19auxLiqDCalculado ;
   private byte GXv_int8[] ;
   private short AV13EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV14LiqNro ;
   private int AV15LiqRelNro ;
   private int AV17LegNumero ;
   private java.math.BigDecimal AV27Importes ;
   private java.math.BigDecimal AV12auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV23aux2LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal AV22menorLiqDImpCalcu ;
   private String AV18ProcesoLiquidacion ;
   private String AV10auxConCodigo ;
   private String AV32Pgmname ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char9[] ;
   private java.util.Date AV16LiqPeriodo ;
   private boolean AV28existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean5[] ;
   private String AV8LiqDLog ;
   private String AV25OpeCliValor ;
   private String AV29auxLiqDLog ;
   private String AV21Error ;
   private String AV9ConDescrip ;
   private String AV26auxError ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
}

