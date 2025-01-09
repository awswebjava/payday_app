package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armarparmdesdesdtdatosliq extends GXProcedure
{
   public armarparmdesdesdtdatosliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armarparmdesdesdtdatosliq.class ), "" );
   }

   public armarparmdesdesdtdatosliq( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( web.Sdtsdt_datos_liq aP0 ,
                             int[] aP1 ,
                             short[] aP2 ,
                             int[] aP3 ,
                             java.util.Date[] aP4 ,
                             java.util.Date[] aP5 ,
                             String[] aP6 ,
                             byte[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             GXSimpleCollection<Integer>[] aP11 ,
                             String[] aP12 ,
                             java.util.Date[] aP13 ,
                             short[] aP14 ,
                             byte[] aP15 ,
                             byte[] aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             java.util.Date[] aP19 ,
                             String[] aP20 ,
                             String[] aP21 ,
                             int[] aP22 ,
                             String[] aP23 ,
                             String[] aP24 ,
                             java.math.BigDecimal[] aP25 ,
                             String[] aP26 ,
                             boolean[] aP27 ,
                             String[] aP28 ,
                             boolean[] aP29 ,
                             String[] aP30 ,
                             byte[] aP31 ,
                             java.util.Date[] aP32 ,
                             java.util.Date[] aP33 )
   {
      armarparmdesdesdtdatosliq.this.aP34 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34);
      return aP34[0];
   }

   public void execute( web.Sdtsdt_datos_liq aP0 ,
                        int[] aP1 ,
                        short[] aP2 ,
                        int[] aP3 ,
                        java.util.Date[] aP4 ,
                        java.util.Date[] aP5 ,
                        String[] aP6 ,
                        byte[] aP7 ,
                        byte[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        GXSimpleCollection<Integer>[] aP11 ,
                        String[] aP12 ,
                        java.util.Date[] aP13 ,
                        short[] aP14 ,
                        byte[] aP15 ,
                        byte[] aP16 ,
                        short[] aP17 ,
                        boolean[] aP18 ,
                        java.util.Date[] aP19 ,
                        String[] aP20 ,
                        String[] aP21 ,
                        int[] aP22 ,
                        String[] aP23 ,
                        String[] aP24 ,
                        java.math.BigDecimal[] aP25 ,
                        String[] aP26 ,
                        boolean[] aP27 ,
                        String[] aP28 ,
                        boolean[] aP29 ,
                        String[] aP30 ,
                        byte[] aP31 ,
                        java.util.Date[] aP32 ,
                        java.util.Date[] aP33 ,
                        String[] aP34 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34);
   }

   private void execute_int( web.Sdtsdt_datos_liq aP0 ,
                             int[] aP1 ,
                             short[] aP2 ,
                             int[] aP3 ,
                             java.util.Date[] aP4 ,
                             java.util.Date[] aP5 ,
                             String[] aP6 ,
                             byte[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             GXSimpleCollection<Integer>[] aP11 ,
                             String[] aP12 ,
                             java.util.Date[] aP13 ,
                             short[] aP14 ,
                             byte[] aP15 ,
                             byte[] aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             java.util.Date[] aP19 ,
                             String[] aP20 ,
                             String[] aP21 ,
                             int[] aP22 ,
                             String[] aP23 ,
                             String[] aP24 ,
                             java.math.BigDecimal[] aP25 ,
                             String[] aP26 ,
                             boolean[] aP27 ,
                             String[] aP28 ,
                             boolean[] aP29 ,
                             String[] aP30 ,
                             byte[] aP31 ,
                             java.util.Date[] aP32 ,
                             java.util.Date[] aP33 ,
                             String[] aP34 )
   {
      armarparmdesdesdtdatosliq.this.AV34sdt_datos_liq = aP0;
      armarparmdesdesdtdatosliq.this.aP1 = aP1;
      armarparmdesdesdtdatosliq.this.aP2 = aP2;
      armarparmdesdesdtdatosliq.this.aP3 = aP3;
      armarparmdesdesdtdatosliq.this.aP4 = aP4;
      armarparmdesdesdtdatosliq.this.aP5 = aP5;
      armarparmdesdesdtdatosliq.this.aP6 = aP6;
      armarparmdesdesdtdatosliq.this.aP7 = aP7;
      armarparmdesdesdtdatosliq.this.aP8 = aP8;
      armarparmdesdesdtdatosliq.this.aP9 = aP9;
      armarparmdesdesdtdatosliq.this.aP10 = aP10;
      armarparmdesdesdtdatosliq.this.aP11 = aP11;
      armarparmdesdesdtdatosliq.this.aP12 = aP12;
      armarparmdesdesdtdatosliq.this.aP13 = aP13;
      armarparmdesdesdtdatosliq.this.aP14 = aP14;
      armarparmdesdesdtdatosliq.this.aP15 = aP15;
      armarparmdesdesdtdatosliq.this.aP16 = aP16;
      armarparmdesdesdtdatosliq.this.aP17 = aP17;
      armarparmdesdesdtdatosliq.this.aP18 = aP18;
      armarparmdesdesdtdatosliq.this.aP19 = aP19;
      armarparmdesdesdtdatosliq.this.aP20 = aP20;
      armarparmdesdesdtdatosliq.this.aP21 = aP21;
      armarparmdesdesdtdatosliq.this.aP22 = aP22;
      armarparmdesdesdtdatosliq.this.aP23 = aP23;
      armarparmdesdesdtdatosliq.this.aP24 = aP24;
      armarparmdesdesdtdatosliq.this.aP25 = aP25;
      armarparmdesdesdtdatosliq.this.aP26 = aP26;
      armarparmdesdesdtdatosliq.this.aP27 = aP27;
      armarparmdesdesdtdatosliq.this.aP28 = aP28;
      armarparmdesdesdtdatosliq.this.aP29 = aP29;
      armarparmdesdesdtdatosliq.this.aP30 = aP30;
      armarparmdesdesdtdatosliq.this.aP31 = aP31;
      armarparmdesdesdtdatosliq.this.aP32 = aP32;
      armarparmdesdesdtdatosliq.this.aP33 = aP33;
      armarparmdesdesdtdatosliq.this.aP34 = aP34;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12CliCod = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Clicod() ;
      AV15EmpCod = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Empcod() ;
      AV27LiqNro = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqnro() ;
      AV23LiqFecha = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqfecha() ;
      AV25LiqFecPago = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqfecpago() ;
      AV21LiqDescrip = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqdescrip() ;
      AV16LiqClase = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqclase() ;
      AV22LiqEstado = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqestado() ;
      AV35TLiqCod = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Tliqcod() ;
      AV11AplicaA = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Aplicaa() ;
      AV14collecion_LegNumero.fromJSonString(AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Legnumero_obj(), null);
      AV17LiqDepBanCod = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqdepbancod() ;
      AV20LiqDepPrvFec = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqdepprvfec() ;
      AV18LiqDepPerAno = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqdepperano() ;
      AV19LiqDepPerMes = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqdeppermes() ;
      AV29LiqPerMes = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqpermes() ;
      AV28LiqPerAno = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqperano() ;
      AV24LiqFecImp = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqfecimp() ;
      AV33parmLiqPerPalabra = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Parmliqperpalabra() ;
      AV26LiqNombre = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqnombre() ;
      AV30LiqRelNro = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqrelnro() ;
      AV13ClientId = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Clientid() ;
      AV31LiqSac = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqsac() ;
      AV32LiqSacLog = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqsaclog() ;
      AV38reLiquidacion = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Reliquidacion() ;
      AV39LiqModTra = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqmodtra() ;
      AV42LiqFrecPag = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqfrecpag() ;
      AV41LiqPerDes = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqperdes() ;
      AV40LiqPerHas = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqperhas() ;
      AV43LiqTipoTarifa = AV34sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqtipotarifa() ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = armarparmdesdesdtdatosliq.this.AV12CliCod;
      this.aP2[0] = armarparmdesdesdtdatosliq.this.AV15EmpCod;
      this.aP3[0] = armarparmdesdesdtdatosliq.this.AV27LiqNro;
      this.aP4[0] = armarparmdesdesdtdatosliq.this.AV23LiqFecha;
      this.aP5[0] = armarparmdesdesdtdatosliq.this.AV25LiqFecPago;
      this.aP6[0] = armarparmdesdesdtdatosliq.this.AV21LiqDescrip;
      this.aP7[0] = armarparmdesdesdtdatosliq.this.AV16LiqClase;
      this.aP8[0] = armarparmdesdesdtdatosliq.this.AV22LiqEstado;
      this.aP9[0] = armarparmdesdesdtdatosliq.this.AV35TLiqCod;
      this.aP10[0] = armarparmdesdesdtdatosliq.this.AV11AplicaA;
      this.aP11[0] = armarparmdesdesdtdatosliq.this.AV14collecion_LegNumero;
      this.aP12[0] = armarparmdesdesdtdatosliq.this.AV17LiqDepBanCod;
      this.aP13[0] = armarparmdesdesdtdatosliq.this.AV20LiqDepPrvFec;
      this.aP14[0] = armarparmdesdesdtdatosliq.this.AV18LiqDepPerAno;
      this.aP15[0] = armarparmdesdesdtdatosliq.this.AV19LiqDepPerMes;
      this.aP16[0] = armarparmdesdesdtdatosliq.this.AV29LiqPerMes;
      this.aP17[0] = armarparmdesdesdtdatosliq.this.AV28LiqPerAno;
      this.aP18[0] = armarparmdesdesdtdatosliq.this.AV36final;
      this.aP19[0] = armarparmdesdesdtdatosliq.this.AV24LiqFecImp;
      this.aP20[0] = armarparmdesdesdtdatosliq.this.AV33parmLiqPerPalabra;
      this.aP21[0] = armarparmdesdesdtdatosliq.this.AV26LiqNombre;
      this.aP22[0] = armarparmdesdesdtdatosliq.this.AV30LiqRelNro;
      this.aP23[0] = armarparmdesdesdtdatosliq.this.AV9parmLiqLegConvenio;
      this.aP24[0] = armarparmdesdesdtdatosliq.this.AV8parmLiqLegCatCodigo;
      this.aP25[0] = armarparmdesdesdtdatosliq.this.AV10parmLiqLegSueldo;
      this.aP26[0] = armarparmdesdesdtdatosliq.this.AV13ClientId;
      this.aP27[0] = armarparmdesdesdtdatosliq.this.AV31LiqSac;
      this.aP28[0] = armarparmdesdesdtdatosliq.this.AV32LiqSacLog;
      this.aP29[0] = armarparmdesdesdtdatosliq.this.AV38reLiquidacion;
      this.aP30[0] = armarparmdesdesdtdatosliq.this.AV39LiqModTra;
      this.aP31[0] = armarparmdesdesdtdatosliq.this.AV42LiqFrecPag;
      this.aP32[0] = armarparmdesdesdtdatosliq.this.AV41LiqPerDes;
      this.aP33[0] = armarparmdesdesdtdatosliq.this.AV40LiqPerHas;
      this.aP34[0] = armarparmdesdesdtdatosliq.this.AV43LiqTipoTarifa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23LiqFecha = GXutil.nullDate() ;
      AV25LiqFecPago = GXutil.nullDate() ;
      AV21LiqDescrip = "" ;
      AV35TLiqCod = "" ;
      AV11AplicaA = "" ;
      AV14collecion_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV17LiqDepBanCod = "" ;
      AV20LiqDepPrvFec = GXutil.nullDate() ;
      AV24LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      AV33parmLiqPerPalabra = "" ;
      AV26LiqNombre = "" ;
      AV9parmLiqLegConvenio = "" ;
      AV8parmLiqLegCatCodigo = "" ;
      AV10parmLiqLegSueldo = DecimalUtil.ZERO ;
      AV13ClientId = "" ;
      AV32LiqSacLog = "" ;
      AV39LiqModTra = "" ;
      AV41LiqPerDes = GXutil.nullDate() ;
      AV40LiqPerHas = GXutil.nullDate() ;
      AV43LiqTipoTarifa = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqClase ;
   private byte AV22LiqEstado ;
   private byte AV19LiqDepPerMes ;
   private byte AV29LiqPerMes ;
   private byte AV42LiqFrecPag ;
   private short AV15EmpCod ;
   private short AV18LiqDepPerAno ;
   private short AV28LiqPerAno ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV27LiqNro ;
   private int AV30LiqRelNro ;
   private java.math.BigDecimal AV10parmLiqLegSueldo ;
   private String AV35TLiqCod ;
   private String AV11AplicaA ;
   private String AV17LiqDepBanCod ;
   private String AV33parmLiqPerPalabra ;
   private String AV9parmLiqLegConvenio ;
   private String AV8parmLiqLegCatCodigo ;
   private String AV39LiqModTra ;
   private String AV43LiqTipoTarifa ;
   private java.util.Date AV24LiqFecImp ;
   private java.util.Date AV23LiqFecha ;
   private java.util.Date AV25LiqFecPago ;
   private java.util.Date AV20LiqDepPrvFec ;
   private java.util.Date AV41LiqPerDes ;
   private java.util.Date AV40LiqPerHas ;
   private boolean AV36final ;
   private boolean AV31LiqSac ;
   private boolean AV38reLiquidacion ;
   private String AV21LiqDescrip ;
   private String AV26LiqNombre ;
   private String AV13ClientId ;
   private String AV32LiqSacLog ;
   private GXSimpleCollection<Integer> AV14collecion_LegNumero ;
   private String[] aP34 ;
   private int[] aP1 ;
   private short[] aP2 ;
   private int[] aP3 ;
   private java.util.Date[] aP4 ;
   private java.util.Date[] aP5 ;
   private String[] aP6 ;
   private byte[] aP7 ;
   private byte[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private GXSimpleCollection<Integer>[] aP11 ;
   private String[] aP12 ;
   private java.util.Date[] aP13 ;
   private short[] aP14 ;
   private byte[] aP15 ;
   private byte[] aP16 ;
   private short[] aP17 ;
   private boolean[] aP18 ;
   private java.util.Date[] aP19 ;
   private String[] aP20 ;
   private String[] aP21 ;
   private int[] aP22 ;
   private String[] aP23 ;
   private String[] aP24 ;
   private java.math.BigDecimal[] aP25 ;
   private String[] aP26 ;
   private boolean[] aP27 ;
   private String[] aP28 ;
   private boolean[] aP29 ;
   private String[] aP30 ;
   private byte[] aP31 ;
   private java.util.Date[] aP32 ;
   private java.util.Date[] aP33 ;
   private web.Sdtsdt_datos_liq AV34sdt_datos_liq ;
}

