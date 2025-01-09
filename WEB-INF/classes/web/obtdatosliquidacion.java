package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtdatosliquidacion extends GXProcedure
{
   public obtdatosliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtdatosliquidacion.class ), "" );
   }

   public obtdatosliquidacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( short aP0 ,
                                     int aP1 ,
                                     String[] aP2 ,
                                     java.util.Date[] aP3 ,
                                     byte[] aP4 ,
                                     String[] aP5 ,
                                     byte[] aP6 ,
                                     String[] aP7 ,
                                     String[] aP8 ,
                                     GXSimpleCollection<Integer>[] aP9 ,
                                     String[] aP10 ,
                                     byte[] aP11 ,
                                     java.util.Date[] aP12 ,
                                     String[] aP13 ,
                                     java.util.Date[] aP14 ,
                                     short[] aP15 ,
                                     byte[] aP16 ,
                                     short[] aP17 ,
                                     byte[] aP18 ,
                                     String[] aP19 ,
                                     String[] aP20 ,
                                     java.util.Date[] aP21 )
   {
      obtdatosliquidacion.this.aP22 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
      return aP22[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String[] aP2 ,
                        java.util.Date[] aP3 ,
                        byte[] aP4 ,
                        String[] aP5 ,
                        byte[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        GXSimpleCollection<Integer>[] aP9 ,
                        String[] aP10 ,
                        byte[] aP11 ,
                        java.util.Date[] aP12 ,
                        String[] aP13 ,
                        java.util.Date[] aP14 ,
                        short[] aP15 ,
                        byte[] aP16 ,
                        short[] aP17 ,
                        byte[] aP18 ,
                        String[] aP19 ,
                        String[] aP20 ,
                        java.util.Date[] aP21 ,
                        java.util.Date[] aP22 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String[] aP2 ,
                             java.util.Date[] aP3 ,
                             byte[] aP4 ,
                             String[] aP5 ,
                             byte[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             GXSimpleCollection<Integer>[] aP9 ,
                             String[] aP10 ,
                             byte[] aP11 ,
                             java.util.Date[] aP12 ,
                             String[] aP13 ,
                             java.util.Date[] aP14 ,
                             short[] aP15 ,
                             byte[] aP16 ,
                             short[] aP17 ,
                             byte[] aP18 ,
                             String[] aP19 ,
                             String[] aP20 ,
                             java.util.Date[] aP21 ,
                             java.util.Date[] aP22 )
   {
      obtdatosliquidacion.this.AV8EmpCod = aP0;
      obtdatosliquidacion.this.AV16LiqNro = aP1;
      obtdatosliquidacion.this.aP2 = aP2;
      obtdatosliquidacion.this.aP3 = aP3;
      obtdatosliquidacion.this.aP4 = aP4;
      obtdatosliquidacion.this.aP5 = aP5;
      obtdatosliquidacion.this.aP6 = aP6;
      obtdatosliquidacion.this.aP7 = aP7;
      obtdatosliquidacion.this.aP8 = aP8;
      obtdatosliquidacion.this.aP9 = aP9;
      obtdatosliquidacion.this.aP10 = aP10;
      obtdatosliquidacion.this.aP11 = aP11;
      obtdatosliquidacion.this.aP12 = aP12;
      obtdatosliquidacion.this.aP13 = aP13;
      obtdatosliquidacion.this.aP14 = aP14;
      obtdatosliquidacion.this.aP15 = aP15;
      obtdatosliquidacion.this.aP16 = aP16;
      obtdatosliquidacion.this.aP17 = aP17;
      obtdatosliquidacion.this.aP18 = aP18;
      obtdatosliquidacion.this.aP19 = aP19;
      obtdatosliquidacion.this.aP20 = aP20;
      obtdatosliquidacion.this.aP21 = aP21;
      obtdatosliquidacion.this.aP22 = aP22;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV21CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      obtdatosliquidacion.this.GXt_int1 = GXv_int2[0] ;
      AV21CliCod = GXt_int1 ;
      /* Using cursor P009O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV21CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV16LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P009O2_A31LiqNro[0] ;
         A1EmpCod = P009O2_A1EmpCod[0] ;
         A3CliCod = P009O2_A3CliCod[0] ;
         A271LiqDescrip = P009O2_A271LiqDescrip[0] ;
         A98LiqFecha = P009O2_A98LiqFecha[0] ;
         A268LiqClase = P009O2_A268LiqClase[0] ;
         n268LiqClase = P009O2_n268LiqClase[0] ;
         A2409LiqModTra = P009O2_A2409LiqModTra[0] ;
         A2414LiqFrecPag = P009O2_A2414LiqFrecPag[0] ;
         A2426LiqTipoTarifa = P009O2_A2426LiqTipoTarifa[0] ;
         A2410LiqPerDes = P009O2_A2410LiqPerDes[0] ;
         A2411LiqPerHas = P009O2_A2411LiqPerHas[0] ;
         A32TLiqCod = P009O2_A32TLiqCod[0] ;
         n32TLiqCod = P009O2_n32TLiqCod[0] ;
         A278LiqEstado = P009O2_A278LiqEstado[0] ;
         A280LiqFecPago = P009O2_A280LiqFecPago[0] ;
         A581LiqDepPrvFec = P009O2_A581LiqDepPrvFec[0] ;
         A33LiqDepBanCod = P009O2_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = P009O2_n33LiqDepBanCod[0] ;
         A583LiqDepPerAno = P009O2_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = P009O2_A584LiqDepPerMes[0] ;
         A585LiqPerAno = P009O2_A585LiqPerAno[0] ;
         A586LiqPerMes = P009O2_A586LiqPerMes[0] ;
         A874LiqNombre = P009O2_A874LiqNombre[0] ;
         A748LiqPerPalabra = P009O2_A748LiqPerPalabra[0] ;
         A500LegEspecificos = P009O2_A500LegEspecificos[0] ;
         AV12LiqDescrip = A271LiqDescrip ;
         AV15LiqFecha = A98LiqFecha ;
         AV11LiqClase = A268LiqClase ;
         AV32LiqModTra = A2409LiqModTra ;
         AV31LiqFrecPag = A2414LiqFrecPag ;
         AV35LiqTipoTarifa = A2426LiqTipoTarifa ;
         AV33LiqPerDes = A2410LiqPerDes ;
         AV34LiqPerHas = A2411LiqPerHas ;
         AV17TLiqCod = A32TLiqCod ;
         AV13LiqEstado = A278LiqEstado ;
         AV22LiqFecPago = A280LiqFecPago ;
         AV23LiqDepPrvFec = A581LiqDepPrvFec ;
         AV24LiqDepBanCod = A33LiqDepBanCod ;
         AV25LiqDepPerAno = A583LiqDepPerAno ;
         AV26LiqDepPerMes = A584LiqDepPerMes ;
         AV27LiqPerAno = A585LiqPerAno ;
         AV28LiqPerMes = A586LiqPerMes ;
         AV29LiqNombre = A874LiqNombre ;
         AV30LiqPerPalabra = A748LiqPerPalabra ;
         if ( A500LegEspecificos )
         {
            AV20AplicaA = httpContext.getMessage( "ALGUNOS", "") ;
         }
         else
         {
            AV20AplicaA = httpContext.getMessage( "TODOS", "") ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P009O3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV21CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV16LiqNro)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A31LiqNro = P009O3_A31LiqNro[0] ;
         A1EmpCod = P009O3_A1EmpCod[0] ;
         A3CliCod = P009O3_A3CliCod[0] ;
         A281LiqLegImpTotal = P009O3_A281LiqLegImpTotal[0] ;
         A6LegNumero = P009O3_A6LegNumero[0] ;
         AV9LegNumero.add((int)(A6LegNumero), 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = obtdatosliquidacion.this.AV12LiqDescrip;
      this.aP3[0] = obtdatosliquidacion.this.AV15LiqFecha;
      this.aP4[0] = obtdatosliquidacion.this.AV11LiqClase;
      this.aP5[0] = obtdatosliquidacion.this.AV32LiqModTra;
      this.aP6[0] = obtdatosliquidacion.this.AV31LiqFrecPag;
      this.aP7[0] = obtdatosliquidacion.this.AV35LiqTipoTarifa;
      this.aP8[0] = obtdatosliquidacion.this.AV17TLiqCod;
      this.aP9[0] = obtdatosliquidacion.this.AV9LegNumero;
      this.aP10[0] = obtdatosliquidacion.this.AV20AplicaA;
      this.aP11[0] = obtdatosliquidacion.this.AV13LiqEstado;
      this.aP12[0] = obtdatosliquidacion.this.AV22LiqFecPago;
      this.aP13[0] = obtdatosliquidacion.this.AV24LiqDepBanCod;
      this.aP14[0] = obtdatosliquidacion.this.AV23LiqDepPrvFec;
      this.aP15[0] = obtdatosliquidacion.this.AV25LiqDepPerAno;
      this.aP16[0] = obtdatosliquidacion.this.AV26LiqDepPerMes;
      this.aP17[0] = obtdatosliquidacion.this.AV27LiqPerAno;
      this.aP18[0] = obtdatosliquidacion.this.AV28LiqPerMes;
      this.aP19[0] = obtdatosliquidacion.this.AV29LiqNombre;
      this.aP20[0] = obtdatosliquidacion.this.AV30LiqPerPalabra;
      this.aP21[0] = obtdatosliquidacion.this.AV33LiqPerDes;
      this.aP22[0] = obtdatosliquidacion.this.AV34LiqPerHas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDescrip = "" ;
      AV15LiqFecha = GXutil.nullDate() ;
      AV32LiqModTra = "" ;
      AV35LiqTipoTarifa = "" ;
      AV17TLiqCod = "" ;
      AV9LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV20AplicaA = "" ;
      AV22LiqFecPago = GXutil.nullDate() ;
      AV24LiqDepBanCod = "" ;
      AV23LiqDepPrvFec = GXutil.nullDate() ;
      AV29LiqNombre = "" ;
      AV30LiqPerPalabra = "" ;
      AV33LiqPerDes = GXutil.nullDate() ;
      AV34LiqPerHas = GXutil.nullDate() ;
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P009O2_A31LiqNro = new int[1] ;
      P009O2_A1EmpCod = new short[1] ;
      P009O2_A3CliCod = new int[1] ;
      P009O2_A271LiqDescrip = new String[] {""} ;
      P009O2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P009O2_A268LiqClase = new byte[1] ;
      P009O2_n268LiqClase = new boolean[] {false} ;
      P009O2_A2409LiqModTra = new String[] {""} ;
      P009O2_A2414LiqFrecPag = new byte[1] ;
      P009O2_A2426LiqTipoTarifa = new String[] {""} ;
      P009O2_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      P009O2_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      P009O2_A32TLiqCod = new String[] {""} ;
      P009O2_n32TLiqCod = new boolean[] {false} ;
      P009O2_A278LiqEstado = new byte[1] ;
      P009O2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P009O2_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      P009O2_A33LiqDepBanCod = new String[] {""} ;
      P009O2_n33LiqDepBanCod = new boolean[] {false} ;
      P009O2_A583LiqDepPerAno = new short[1] ;
      P009O2_A584LiqDepPerMes = new byte[1] ;
      P009O2_A585LiqPerAno = new short[1] ;
      P009O2_A586LiqPerMes = new byte[1] ;
      P009O2_A874LiqNombre = new String[] {""} ;
      P009O2_A748LiqPerPalabra = new String[] {""} ;
      P009O2_A500LegEspecificos = new boolean[] {false} ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A2409LiqModTra = "" ;
      A2426LiqTipoTarifa = "" ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A33LiqDepBanCod = "" ;
      A874LiqNombre = "" ;
      A748LiqPerPalabra = "" ;
      P009O3_A31LiqNro = new int[1] ;
      P009O3_A1EmpCod = new short[1] ;
      P009O3_A3CliCod = new int[1] ;
      P009O3_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P009O3_A6LegNumero = new int[1] ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtdatosliquidacion__default(),
         new Object[] {
             new Object[] {
            P009O2_A31LiqNro, P009O2_A1EmpCod, P009O2_A3CliCod, P009O2_A271LiqDescrip, P009O2_A98LiqFecha, P009O2_A268LiqClase, P009O2_n268LiqClase, P009O2_A2409LiqModTra, P009O2_A2414LiqFrecPag, P009O2_A2426LiqTipoTarifa,
            P009O2_A2410LiqPerDes, P009O2_A2411LiqPerHas, P009O2_A32TLiqCod, P009O2_n32TLiqCod, P009O2_A278LiqEstado, P009O2_A280LiqFecPago, P009O2_A581LiqDepPrvFec, P009O2_A33LiqDepBanCod, P009O2_n33LiqDepBanCod, P009O2_A583LiqDepPerAno,
            P009O2_A584LiqDepPerMes, P009O2_A585LiqPerAno, P009O2_A586LiqPerMes, P009O2_A874LiqNombre, P009O2_A748LiqPerPalabra, P009O2_A500LegEspecificos
            }
            , new Object[] {
            P009O3_A31LiqNro, P009O3_A1EmpCod, P009O3_A3CliCod, P009O3_A281LiqLegImpTotal, P009O3_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11LiqClase ;
   private byte AV31LiqFrecPag ;
   private byte AV13LiqEstado ;
   private byte AV26LiqDepPerMes ;
   private byte AV28LiqPerMes ;
   private byte A268LiqClase ;
   private byte A2414LiqFrecPag ;
   private byte A278LiqEstado ;
   private byte A584LiqDepPerMes ;
   private byte A586LiqPerMes ;
   private short AV8EmpCod ;
   private short AV25LiqDepPerAno ;
   private short AV27LiqPerAno ;
   private short A1EmpCod ;
   private short A583LiqDepPerAno ;
   private short A585LiqPerAno ;
   private short Gx_err ;
   private int AV16LiqNro ;
   private int AV21CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String AV32LiqModTra ;
   private String AV35LiqTipoTarifa ;
   private String AV17TLiqCod ;
   private String AV20AplicaA ;
   private String AV24LiqDepBanCod ;
   private String AV30LiqPerPalabra ;
   private String scmdbuf ;
   private String A2409LiqModTra ;
   private String A2426LiqTipoTarifa ;
   private String A32TLiqCod ;
   private String A33LiqDepBanCod ;
   private String A748LiqPerPalabra ;
   private java.util.Date AV15LiqFecha ;
   private java.util.Date AV22LiqFecPago ;
   private java.util.Date AV23LiqDepPrvFec ;
   private java.util.Date AV33LiqPerDes ;
   private java.util.Date AV34LiqPerHas ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A581LiqDepPrvFec ;
   private boolean n268LiqClase ;
   private boolean n32TLiqCod ;
   private boolean n33LiqDepBanCod ;
   private boolean A500LegEspecificos ;
   private String AV12LiqDescrip ;
   private String AV29LiqNombre ;
   private String A271LiqDescrip ;
   private String A874LiqNombre ;
   private GXSimpleCollection<Integer> AV9LegNumero ;
   private java.util.Date[] aP22 ;
   private String[] aP2 ;
   private java.util.Date[] aP3 ;
   private byte[] aP4 ;
   private String[] aP5 ;
   private byte[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private GXSimpleCollection<Integer>[] aP9 ;
   private String[] aP10 ;
   private byte[] aP11 ;
   private java.util.Date[] aP12 ;
   private String[] aP13 ;
   private java.util.Date[] aP14 ;
   private short[] aP15 ;
   private byte[] aP16 ;
   private short[] aP17 ;
   private byte[] aP18 ;
   private String[] aP19 ;
   private String[] aP20 ;
   private java.util.Date[] aP21 ;
   private IDataStoreProvider pr_default ;
   private int[] P009O2_A31LiqNro ;
   private short[] P009O2_A1EmpCod ;
   private int[] P009O2_A3CliCod ;
   private String[] P009O2_A271LiqDescrip ;
   private java.util.Date[] P009O2_A98LiqFecha ;
   private byte[] P009O2_A268LiqClase ;
   private boolean[] P009O2_n268LiqClase ;
   private String[] P009O2_A2409LiqModTra ;
   private byte[] P009O2_A2414LiqFrecPag ;
   private String[] P009O2_A2426LiqTipoTarifa ;
   private java.util.Date[] P009O2_A2410LiqPerDes ;
   private java.util.Date[] P009O2_A2411LiqPerHas ;
   private String[] P009O2_A32TLiqCod ;
   private boolean[] P009O2_n32TLiqCod ;
   private byte[] P009O2_A278LiqEstado ;
   private java.util.Date[] P009O2_A280LiqFecPago ;
   private java.util.Date[] P009O2_A581LiqDepPrvFec ;
   private String[] P009O2_A33LiqDepBanCod ;
   private boolean[] P009O2_n33LiqDepBanCod ;
   private short[] P009O2_A583LiqDepPerAno ;
   private byte[] P009O2_A584LiqDepPerMes ;
   private short[] P009O2_A585LiqPerAno ;
   private byte[] P009O2_A586LiqPerMes ;
   private String[] P009O2_A874LiqNombre ;
   private String[] P009O2_A748LiqPerPalabra ;
   private boolean[] P009O2_A500LegEspecificos ;
   private int[] P009O3_A31LiqNro ;
   private short[] P009O3_A1EmpCod ;
   private int[] P009O3_A3CliCod ;
   private java.math.BigDecimal[] P009O3_A281LiqLegImpTotal ;
   private int[] P009O3_A6LegNumero ;
}

final  class obtdatosliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009O2", "SELECT LiqNro, EmpCod, CliCod, LiqDescrip, LiqFecha, LiqClase, LiqModTra, LiqFrecPag, LiqTipoTarifa, LiqPerDes, LiqPerHas, TLiqCod, LiqEstado, LiqFecPago, LiqDepPrvFec, LiqDepBanCod, LiqDepPerAno, LiqDepPerMes, LiqPerAno, LiqPerMes, LiqNombre, LiqPerPalabra, LegEspecificos FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P009O3", "SELECT LiqNro, EmpCod, CliCod, LiqLegImpTotal, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(14);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 6);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((short[]) buf[19])[0] = rslt.getShort(17);
               ((byte[]) buf[20])[0] = rslt.getByte(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((byte[]) buf[22])[0] = rslt.getByte(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(23);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

