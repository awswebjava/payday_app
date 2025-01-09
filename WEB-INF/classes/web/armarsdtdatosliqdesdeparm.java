package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armarsdtdatosliqdesdeparm extends GXProcedure
{
   public armarsdtdatosliqdesdeparm( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armarsdtdatosliqdesdeparm.class ), "" );
   }

   public armarsdtdatosliqdesdeparm( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.Sdtsdt_datos_liq executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 ,
                                           java.util.Date aP4 ,
                                           String aP5 ,
                                           byte aP6 ,
                                           byte aP7 ,
                                           String aP8 ,
                                           String aP9 ,
                                           GXSimpleCollection<Integer> aP10 ,
                                           String aP11 ,
                                           java.util.Date aP12 ,
                                           short aP13 ,
                                           byte aP14 ,
                                           byte aP15 ,
                                           short aP16 ,
                                           boolean aP17 ,
                                           java.util.Date aP18 ,
                                           String aP19 ,
                                           String aP20 ,
                                           int aP21 ,
                                           String aP22 ,
                                           String aP23 ,
                                           java.math.BigDecimal aP24 ,
                                           String aP25 ,
                                           boolean aP26 ,
                                           String aP27 ,
                                           boolean aP28 ,
                                           String aP29 ,
                                           byte aP30 ,
                                           java.util.Date aP31 ,
                                           java.util.Date aP32 ,
                                           String aP33 )
   {
      armarsdtdatosliqdesdeparm.this.aP34 = new web.Sdtsdt_datos_liq[] {new web.Sdtsdt_datos_liq()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34);
      return aP34[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        String aP9 ,
                        GXSimpleCollection<Integer> aP10 ,
                        String aP11 ,
                        java.util.Date aP12 ,
                        short aP13 ,
                        byte aP14 ,
                        byte aP15 ,
                        short aP16 ,
                        boolean aP17 ,
                        java.util.Date aP18 ,
                        String aP19 ,
                        String aP20 ,
                        int aP21 ,
                        String aP22 ,
                        String aP23 ,
                        java.math.BigDecimal aP24 ,
                        String aP25 ,
                        boolean aP26 ,
                        String aP27 ,
                        boolean aP28 ,
                        String aP29 ,
                        byte aP30 ,
                        java.util.Date aP31 ,
                        java.util.Date aP32 ,
                        String aP33 ,
                        web.Sdtsdt_datos_liq[] aP34 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             String aP9 ,
                             GXSimpleCollection<Integer> aP10 ,
                             String aP11 ,
                             java.util.Date aP12 ,
                             short aP13 ,
                             byte aP14 ,
                             byte aP15 ,
                             short aP16 ,
                             boolean aP17 ,
                             java.util.Date aP18 ,
                             String aP19 ,
                             String aP20 ,
                             int aP21 ,
                             String aP22 ,
                             String aP23 ,
                             java.math.BigDecimal aP24 ,
                             String aP25 ,
                             boolean aP26 ,
                             String aP27 ,
                             boolean aP28 ,
                             String aP29 ,
                             byte aP30 ,
                             java.util.Date aP31 ,
                             java.util.Date aP32 ,
                             String aP33 ,
                             web.Sdtsdt_datos_liq[] aP34 )
   {
      armarsdtdatosliqdesdeparm.this.AV12CliCod = aP0;
      armarsdtdatosliqdesdeparm.this.AV15EmpCod = aP1;
      armarsdtdatosliqdesdeparm.this.AV27LiqNro = aP2;
      armarsdtdatosliqdesdeparm.this.AV23LiqFecha = aP3;
      armarsdtdatosliqdesdeparm.this.AV25LiqFecPago = aP4;
      armarsdtdatosliqdesdeparm.this.AV21LiqDescrip = aP5;
      armarsdtdatosliqdesdeparm.this.AV16LiqClase = aP6;
      armarsdtdatosliqdesdeparm.this.AV22LiqEstado = aP7;
      armarsdtdatosliqdesdeparm.this.AV35TLiqCod = aP8;
      armarsdtdatosliqdesdeparm.this.AV11AplicaA = aP9;
      armarsdtdatosliqdesdeparm.this.AV14collecion_LegNumero = aP10;
      armarsdtdatosliqdesdeparm.this.AV17LiqDepBanCod = aP11;
      armarsdtdatosliqdesdeparm.this.AV20LiqDepPrvFec = aP12;
      armarsdtdatosliqdesdeparm.this.AV18LiqDepPerAno = aP13;
      armarsdtdatosliqdesdeparm.this.AV19LiqDepPerMes = aP14;
      armarsdtdatosliqdesdeparm.this.AV29LiqPerMes = aP15;
      armarsdtdatosliqdesdeparm.this.AV28LiqPerAno = aP16;
      armarsdtdatosliqdesdeparm.this.AV36final = aP17;
      armarsdtdatosliqdesdeparm.this.AV24LiqFecImp = aP18;
      armarsdtdatosliqdesdeparm.this.AV33parmLiqPerPalabra = aP19;
      armarsdtdatosliqdesdeparm.this.AV26LiqNombre = aP20;
      armarsdtdatosliqdesdeparm.this.AV30LiqRelNro = aP21;
      armarsdtdatosliqdesdeparm.this.AV9parmLiqLegConvenio = aP22;
      armarsdtdatosliqdesdeparm.this.AV8parmLiqLegCatCodigo = aP23;
      armarsdtdatosliqdesdeparm.this.AV10parmLiqLegSueldo = aP24;
      armarsdtdatosliqdesdeparm.this.AV13ClientId = aP25;
      armarsdtdatosliqdesdeparm.this.AV31LiqSac = aP26;
      armarsdtdatosliqdesdeparm.this.AV32LiqSacLog = aP27;
      armarsdtdatosliqdesdeparm.this.AV38reLiquida = aP28;
      armarsdtdatosliqdesdeparm.this.AV42LiqModTra = aP29;
      armarsdtdatosliqdesdeparm.this.AV41LiqFrecPag = aP30;
      armarsdtdatosliqdesdeparm.this.AV39LiqPerDes = aP31;
      armarsdtdatosliqdesdeparm.this.AV40LiqPerHas = aP32;
      armarsdtdatosliqdesdeparm.this.AV43LiqTipoTarifa = aP33;
      armarsdtdatosliqdesdeparm.this.aP34 = aP34;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Clicod( AV12CliCod );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Empcod( AV15EmpCod );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqnro( AV27LiqNro );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqfecha( AV23LiqFecha );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqfecpago( AV25LiqFecPago );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqdescrip( AV21LiqDescrip );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqclase( AV16LiqClase );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqestado( AV22LiqEstado );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Tliqcod( AV35TLiqCod );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Aplicaa( AV11AplicaA );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Legnumero_obj( AV14collecion_LegNumero.toJSonString(false) );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqdepbancod( AV17LiqDepBanCod );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqdepprvfec( AV20LiqDepPrvFec );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqdepperano( AV18LiqDepPerAno );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqdeppermes( AV19LiqDepPerMes );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqpermes( AV29LiqPerMes );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqperano( AV28LiqPerAno );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqfecimp( AV24LiqFecImp );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Parmliqperpalabra( AV33parmLiqPerPalabra );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqnombre( AV26LiqNombre );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqrelnro( AV30LiqRelNro );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Clientid( AV13ClientId );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqsac( AV31LiqSac );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqsaclog( AV32LiqSacLog );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "env", ""), GXv_char2) ;
      armarsdtdatosliqdesdeparm.this.GXt_char1 = GXv_char2[0] ;
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Env( GXt_char1 );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Reliquidacion( AV38reLiquida );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqtipotarifa( AV43LiqTipoTarifa );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqmodtra( AV42LiqModTra );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqfrecpag( AV41LiqFrecPag );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqperdes( AV39LiqPerDes );
      AV34sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Liqperhas( AV40LiqPerHas );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP34[0] = armarsdtdatosliqdesdeparm.this.AV34sdt_datos_liq;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV34sdt_datos_liq = new web.Sdtsdt_datos_liq(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqClase ;
   private byte AV22LiqEstado ;
   private byte AV19LiqDepPerMes ;
   private byte AV29LiqPerMes ;
   private byte AV41LiqFrecPag ;
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
   private String AV42LiqModTra ;
   private String AV43LiqTipoTarifa ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date AV24LiqFecImp ;
   private java.util.Date AV23LiqFecha ;
   private java.util.Date AV25LiqFecPago ;
   private java.util.Date AV20LiqDepPrvFec ;
   private java.util.Date AV39LiqPerDes ;
   private java.util.Date AV40LiqPerHas ;
   private boolean AV36final ;
   private boolean AV31LiqSac ;
   private boolean AV38reLiquida ;
   private String AV21LiqDescrip ;
   private String AV26LiqNombre ;
   private String AV13ClientId ;
   private String AV32LiqSacLog ;
   private GXSimpleCollection<Integer> AV14collecion_LegNumero ;
   private web.Sdtsdt_datos_liq[] aP34 ;
   private web.Sdtsdt_datos_liq AV34sdt_datos_liq ;
}

