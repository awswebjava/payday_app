package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getporcentajesegunembar extends GXProcedure
{
   public getporcentajesegunembar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getporcentajesegunembar.class ), "" );
   }

   public getporcentajesegunembar( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      getporcentajesegunembar.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 ,
                             String[] aP13 )
   {
      getporcentajesegunembar.this.AV15CliCod = aP0;
      getporcentajesegunembar.this.AV14EmpCod = aP1;
      getporcentajesegunembar.this.AV9PaiCod = aP2;
      getporcentajesegunembar.this.AV13liqnro = aP3;
      getporcentajesegunembar.this.AV16LegNumero = aP4;
      getporcentajesegunembar.this.AV31LiqPeriodo = aP5;
      getporcentajesegunembar.this.AV11EmbargaSec = aP6;
      getporcentajesegunembar.this.AV17ProcesoLiquidacion = aP7;
      getporcentajesegunembar.this.AV18insertandoConceptos = aP8;
      getporcentajesegunembar.this.aP9 = aP9;
      getporcentajesegunembar.this.aP10 = aP10;
      getporcentajesegunembar.this.aP11 = aP11;
      getporcentajesegunembar.this.aP12 = aP12;
      getporcentajesegunembar.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21LiqDCalculado = (byte)(1) ;
      AV8EmbargaDescrip = httpContext.getMessage( "Decreto 484/87", "") ;
      GXv_int1[0] = AV10decreto487_87EmbargaSec ;
      new web.getembargabilidadpordesc(remoteHandle, context).execute( AV9PaiCod, AV8EmbargaDescrip, GXv_int1) ;
      getporcentajesegunembar.this.AV10decreto487_87EmbargaSec = GXv_int1[0] ;
      if ( AV11EmbargaSec == AV10decreto487_87EmbargaSec )
      {
         AV27OblCanCuo = (short)(0) ;
         AV28OblImpFij = DecimalUtil.doubleToDec(0) ;
         GXt_char2 = AV12sueldoBrutoConCodigo ;
         GXt_char3 = AV12sueldoBrutoConCodigo ;
         GXv_char4[0] = GXt_char3 ;
         new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         getporcentajesegunembar.this.GXt_char3 = GXv_char4[0] ;
         GXv_char5[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char3, GXv_char5) ;
         getporcentajesegunembar.this.GXt_char2 = GXv_char5[0] ;
         AV12sueldoBrutoConCodigo = GXt_char2 ;
         GXv_decimal6[0] = AV19brutoLiqDImpCalcu ;
         GXv_boolean7[0] = AV33existe ;
         GXv_int8[0] = AV20brutoLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, AV13liqnro, AV16LegNumero, AV12sueldoBrutoConCodigo, AV17ProcesoLiquidacion, AV18insertandoConceptos, GXv_decimal6, GXv_boolean7, GXv_int8) ;
         getporcentajesegunembar.this.AV19brutoLiqDImpCalcu = GXv_decimal6[0] ;
         getporcentajesegunembar.this.AV33existe = GXv_boolean7[0] ;
         getporcentajesegunembar.this.AV20brutoLiqDCalculado = GXv_int8[0] ;
         if ( ( AV20brutoLiqDCalculado == 0 ) && ( AV33existe ) )
         {
            AV21LiqDCalculado = (byte)(0) ;
            AV22error = httpContext.getMessage( "Falta calcular sueldo bruto", "") ;
            AV23LiqDLog = AV22error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV24OpeCliId = "[smvm]" ;
         GXv_char5[0] = AV32OpeCliValor ;
         GXv_char4[0] = AV34auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV15CliCod, AV24OpeCliId, AV31LiqPeriodo, AV17ProcesoLiquidacion, GXv_char5, GXv_char4) ;
         getporcentajesegunembar.this.AV32OpeCliValor = GXv_char5[0] ;
         getporcentajesegunembar.this.AV34auxError = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV34auxError)==0) )
         {
            AV21LiqDCalculado = (byte)(0) ;
            AV22error = AV34auxError ;
            AV23LiqDLog = AV22error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV25smvmLiqDImpCalcu = CommonUtil.decimalVal( AV32OpeCliValor, ".") ;
         if ( DecimalUtil.compareTo(AV19brutoLiqDImpCalcu, AV25smvmLiqDImpCalcu) <= 0 )
         {
            AV23LiqDLog = httpContext.getMessage( "Sueldo no se embarga porque es menor o igual a 1 salario mínimo, según ", "") + GXutil.trim( AV8EmbargaDescrip) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            AV29baseCalculoLiqDImpCalcu = AV19brutoLiqDImpCalcu.subtract(AV25smvmLiqDImpCalcu) ;
            if ( AV20brutoLiqDCalculado <= (AV25smvmLiqDImpCalcu.multiply(DecimalUtil.doubleToDec(2))).doubleValue() )
            {
               AV30porUnaje = DecimalUtil.stringToDec("0.1") ;
               AV23LiqDLog = httpContext.getMessage( "Por ser el sueldo bruto menor o igual a 2 SMVM Se embarga el 10% del excedente de 1 SMVM ", "") + GXutil.trim( GXutil.str( AV29baseCalculoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " (sueldo bruto ", "") + GXutil.trim( GXutil.str( AV19brutoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " - SMVM ", "") + GXutil.trim( GXutil.str( AV25smvmLiqDImpCalcu, 14, 2)) ;
            }
            else
            {
               AV30porUnaje = DecimalUtil.stringToDec("0.2") ;
               AV23LiqDLog = httpContext.getMessage( "Por ser el sueldo bruto mayor a 2 SMVM Se embarga el 20% del excedente de 1 SMVM ", "") + GXutil.trim( GXutil.str( AV29baseCalculoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " (sueldo bruto ", "") + GXutil.trim( GXutil.str( AV19brutoLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " - SMVM ", "") + GXutil.trim( GXutil.str( AV25smvmLiqDImpCalcu, 14, 2)) ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getporcentajesegunembar.this.AV29baseCalculoLiqDImpCalcu;
      this.aP10[0] = getporcentajesegunembar.this.AV30porUnaje;
      this.aP11[0] = getporcentajesegunembar.this.AV22error;
      this.aP12[0] = getporcentajesegunembar.this.AV21LiqDCalculado;
      this.aP13[0] = getporcentajesegunembar.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29baseCalculoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV30porUnaje = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV23LiqDLog = "" ;
      AV8EmbargaDescrip = "" ;
      GXv_int1 = new short[1] ;
      AV28OblImpFij = DecimalUtil.ZERO ;
      AV12sueldoBrutoConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      AV19brutoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_int8 = new byte[1] ;
      AV24OpeCliId = "" ;
      AV32OpeCliValor = "" ;
      GXv_char5 = new String[1] ;
      AV34auxError = "" ;
      GXv_char4 = new String[1] ;
      AV25smvmLiqDImpCalcu = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21LiqDCalculado ;
   private byte AV20brutoLiqDCalculado ;
   private byte GXv_int8[] ;
   private short AV14EmpCod ;
   private short AV9PaiCod ;
   private short AV11EmbargaSec ;
   private short AV10decreto487_87EmbargaSec ;
   private short GXv_int1[] ;
   private short AV27OblCanCuo ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV13liqnro ;
   private int AV16LegNumero ;
   private java.math.BigDecimal AV29baseCalculoLiqDImpCalcu ;
   private java.math.BigDecimal AV30porUnaje ;
   private java.math.BigDecimal AV28OblImpFij ;
   private java.math.BigDecimal AV19brutoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV25smvmLiqDImpCalcu ;
   private String AV17ProcesoLiquidacion ;
   private String AV12sueldoBrutoConCodigo ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String AV24OpeCliId ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private java.util.Date AV31LiqPeriodo ;
   private boolean AV18insertandoConceptos ;
   private boolean AV33existe ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private String AV23LiqDLog ;
   private String AV32OpeCliValor ;
   private String AV22error ;
   private String AV8EmbargaDescrip ;
   private String AV34auxError ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private byte[] aP12 ;
}

