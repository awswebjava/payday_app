package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajosporfiltros extends GXProcedure
{
   public getlegajosporfiltros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajosporfiltros.class ), "" );
   }

   public getlegajosporfiltros( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Integer> executeUdp( int aP0 ,
                                                  short aP1 ,
                                                  int aP2 ,
                                                  String aP3 ,
                                                  byte aP4 ,
                                                  String aP5 ,
                                                  java.util.Date aP6 ,
                                                  String aP7 ,
                                                  String aP8 ,
                                                  GXSimpleCollection<String> aP9 ,
                                                  GXSimpleCollection<String> aP10 ,
                                                  GXSimpleCollection<String> aP11 ,
                                                  GXSimpleCollection<String> aP12 ,
                                                  GXSimpleCollection<String> aP13 )
   {
      getlegajosporfiltros.this.aP14 = new GXSimpleCollection[] {new GXSimpleCollection<Integer>(Integer.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        String aP8 ,
                        GXSimpleCollection<String> aP9 ,
                        GXSimpleCollection<String> aP10 ,
                        GXSimpleCollection<String> aP11 ,
                        GXSimpleCollection<String> aP12 ,
                        GXSimpleCollection<String> aP13 ,
                        GXSimpleCollection<Integer>[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             GXSimpleCollection<String> aP9 ,
                             GXSimpleCollection<String> aP10 ,
                             GXSimpleCollection<String> aP11 ,
                             GXSimpleCollection<String> aP12 ,
                             GXSimpleCollection<String> aP13 ,
                             GXSimpleCollection<Integer>[] aP14 )
   {
      getlegajosporfiltros.this.AV15CliCod = aP0;
      getlegajosporfiltros.this.AV16EmpCod = aP1;
      getlegajosporfiltros.this.AV17LiqNro = aP2;
      getlegajosporfiltros.this.AV26LiqModTra = aP3;
      getlegajosporfiltros.this.AV25LiqFrecPag = aP4;
      getlegajosporfiltros.this.AV28LiqTipoTarifa = aP5;
      getlegajosporfiltros.this.AV8LiqPeriodo = aP6;
      getlegajosporfiltros.this.AV10TLiqCod = aP7;
      getlegajosporfiltros.this.AV24ConvenioFiltro = aP8;
      getlegajosporfiltros.this.AV18LegConveCodigo = aP9;
      getlegajosporfiltros.this.AV19LegCatCodigo = aP10;
      getlegajosporfiltros.this.AV20LegSecCodigo = aP11;
      getlegajosporfiltros.this.AV21LegPuesCodigo = aP12;
      getlegajosporfiltros.this.AV22LegSucCodigo = aP13;
      getlegajosporfiltros.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11quincenaTLiqCod ;
      GXt_char2 = AV11quincenaTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getlegajosporfiltros.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char2, GXv_char4) ;
      getlegajosporfiltros.this.GXt_char1 = GXv_char4[0] ;
      AV11quincenaTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV10TLiqCod, AV11quincenaTLiqCod) == 0 )
      {
         AV9finDeMesFecha = localUtil.ymdtod( GXutil.year( AV8LiqPeriodo), GXutil.month( AV8LiqPeriodo), 15) ;
      }
      else
      {
         AV9finDeMesFecha = GXutil.eomdate( AV8LiqPeriodo) ;
      }
      GXt_char2 = AV12mensualTLiqCod ;
      GXt_char1 = AV12mensualTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      getlegajosporfiltros.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV15CliCod, GXt_char1, GXv_char3) ;
      getlegajosporfiltros.this.GXt_char2 = GXv_char3[0] ;
      AV12mensualTLiqCod = GXt_char2 ;
      AV14LegClase = AV25LiqFrecPag ;
      AV27LegModTra = AV26LiqModTra ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A937LegConveCodigo ,
                                           AV18LegConveCodigo ,
                                           A939LegCatCodigo ,
                                           AV19LegCatCodigo ,
                                           A1579LegSecCodigo ,
                                           AV20LegSecCodigo ,
                                           A1578LegPuesCodigo ,
                                           AV21LegPuesCodigo ,
                                           A1577LegSucCodigo ,
                                           AV22LegSucCodigo ,
                                           Integer.valueOf(AV18LegConveCodigo.size()) ,
                                           AV24ConvenioFiltro ,
                                           Integer.valueOf(AV19LegCatCodigo.size()) ,
                                           Integer.valueOf(AV20LegSecCodigo.size()) ,
                                           Integer.valueOf(AV21LegPuesCodigo.size()) ,
                                           Integer.valueOf(AV22LegSucCodigo.size()) ,
                                           A245LegFecIngreso ,
                                           AV9finDeMesFecha ,
                                           A244LegFecEgreso ,
                                           AV8LiqPeriodo ,
                                           Byte.valueOf(A235LegClase) ,
                                           Byte.valueOf(AV14LegClase) ,
                                           A2404LegModTra ,
                                           AV27LegModTra ,
                                           A2417LegTipoTarifa ,
                                           AV28LiqTipoTarifa ,
                                           Byte.valueOf(A1818LegEstado) ,
                                           Integer.valueOf(AV15CliCod) ,
                                           Short.valueOf(AV16EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P027B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV16EmpCod), AV9finDeMesFecha, AV8LiqPeriodo, Byte.valueOf(AV14LegClase), AV27LegModTra, AV28LiqTipoTarifa});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1577LegSucCodigo = P027B2_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = P027B2_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = P027B2_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = P027B2_n1578LegPuesCodigo[0] ;
         A1579LegSecCodigo = P027B2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P027B2_n1579LegSecCodigo[0] ;
         A939LegCatCodigo = P027B2_A939LegCatCodigo[0] ;
         n939LegCatCodigo = P027B2_n939LegCatCodigo[0] ;
         A937LegConveCodigo = P027B2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P027B2_n937LegConveCodigo[0] ;
         A1818LegEstado = P027B2_A1818LegEstado[0] ;
         A2417LegTipoTarifa = P027B2_A2417LegTipoTarifa[0] ;
         A2404LegModTra = P027B2_A2404LegModTra[0] ;
         A235LegClase = P027B2_A235LegClase[0] ;
         A244LegFecEgreso = P027B2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P027B2_n244LegFecEgreso[0] ;
         A245LegFecIngreso = P027B2_A245LegFecIngreso[0] ;
         A1EmpCod = P027B2_A1EmpCod[0] ;
         A3CliCod = P027B2_A3CliCod[0] ;
         A6LegNumero = P027B2_A6LegNumero[0] ;
         AV23LegNumero.add((int)(A6LegNumero), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP14[0] = getlegajosporfiltros.this.AV23LegNumero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV11quincenaTLiqCod = "" ;
      AV9finDeMesFecha = GXutil.nullDate() ;
      AV12mensualTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV27LegModTra = "" ;
      scmdbuf = "" ;
      A937LegConveCodigo = "" ;
      A939LegCatCodigo = "" ;
      A1579LegSecCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A1577LegSucCodigo = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      P027B2_A1577LegSucCodigo = new String[] {""} ;
      P027B2_n1577LegSucCodigo = new boolean[] {false} ;
      P027B2_A1578LegPuesCodigo = new String[] {""} ;
      P027B2_n1578LegPuesCodigo = new boolean[] {false} ;
      P027B2_A1579LegSecCodigo = new String[] {""} ;
      P027B2_n1579LegSecCodigo = new boolean[] {false} ;
      P027B2_A939LegCatCodigo = new String[] {""} ;
      P027B2_n939LegCatCodigo = new boolean[] {false} ;
      P027B2_A937LegConveCodigo = new String[] {""} ;
      P027B2_n937LegConveCodigo = new boolean[] {false} ;
      P027B2_A1818LegEstado = new byte[1] ;
      P027B2_A2417LegTipoTarifa = new String[] {""} ;
      P027B2_A2404LegModTra = new String[] {""} ;
      P027B2_A235LegClase = new byte[1] ;
      P027B2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P027B2_n244LegFecEgreso = new boolean[] {false} ;
      P027B2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P027B2_A1EmpCod = new short[1] ;
      P027B2_A3CliCod = new int[1] ;
      P027B2_A6LegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajosporfiltros__default(),
         new Object[] {
             new Object[] {
            P027B2_A1577LegSucCodigo, P027B2_n1577LegSucCodigo, P027B2_A1578LegPuesCodigo, P027B2_n1578LegPuesCodigo, P027B2_A1579LegSecCodigo, P027B2_n1579LegSecCodigo, P027B2_A939LegCatCodigo, P027B2_n939LegCatCodigo, P027B2_A937LegConveCodigo, P027B2_n937LegConveCodigo,
            P027B2_A1818LegEstado, P027B2_A2417LegTipoTarifa, P027B2_A2404LegModTra, P027B2_A235LegClase, P027B2_A244LegFecEgreso, P027B2_n244LegFecEgreso, P027B2_A245LegFecIngreso, P027B2_A1EmpCod, P027B2_A3CliCod, P027B2_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV25LiqFrecPag ;
   private byte AV14LegClase ;
   private byte A235LegClase ;
   private byte A1818LegEstado ;
   private short AV16EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV17LiqNro ;
   private int AV18LegConveCodigo_size ;
   private int AV19LegCatCodigo_size ;
   private int AV20LegSecCodigo_size ;
   private int AV21LegPuesCodigo_size ;
   private int AV22LegSucCodigo_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV26LiqModTra ;
   private String AV28LiqTipoTarifa ;
   private String AV10TLiqCod ;
   private String AV24ConvenioFiltro ;
   private String AV11quincenaTLiqCod ;
   private String AV12mensualTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String AV27LegModTra ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private String A939LegCatCodigo ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private String A1577LegSucCodigo ;
   private String A2404LegModTra ;
   private String A2417LegTipoTarifa ;
   private java.util.Date AV8LiqPeriodo ;
   private java.util.Date AV9finDeMesFecha ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n1577LegSucCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n244LegFecEgreso ;
   private GXSimpleCollection<Integer> AV23LegNumero ;
   private GXSimpleCollection<Integer>[] aP14 ;
   private IDataStoreProvider pr_default ;
   private String[] P027B2_A1577LegSucCodigo ;
   private boolean[] P027B2_n1577LegSucCodigo ;
   private String[] P027B2_A1578LegPuesCodigo ;
   private boolean[] P027B2_n1578LegPuesCodigo ;
   private String[] P027B2_A1579LegSecCodigo ;
   private boolean[] P027B2_n1579LegSecCodigo ;
   private String[] P027B2_A939LegCatCodigo ;
   private boolean[] P027B2_n939LegCatCodigo ;
   private String[] P027B2_A937LegConveCodigo ;
   private boolean[] P027B2_n937LegConveCodigo ;
   private byte[] P027B2_A1818LegEstado ;
   private String[] P027B2_A2417LegTipoTarifa ;
   private String[] P027B2_A2404LegModTra ;
   private byte[] P027B2_A235LegClase ;
   private java.util.Date[] P027B2_A244LegFecEgreso ;
   private boolean[] P027B2_n244LegFecEgreso ;
   private java.util.Date[] P027B2_A245LegFecIngreso ;
   private short[] P027B2_A1EmpCod ;
   private int[] P027B2_A3CliCod ;
   private int[] P027B2_A6LegNumero ;
   private GXSimpleCollection<String> AV18LegConveCodigo ;
   private GXSimpleCollection<String> AV19LegCatCodigo ;
   private GXSimpleCollection<String> AV20LegSecCodigo ;
   private GXSimpleCollection<String> AV21LegPuesCodigo ;
   private GXSimpleCollection<String> AV22LegSucCodigo ;
}

final  class getlegajosporfiltros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P027B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A937LegConveCodigo ,
                                          GXSimpleCollection<String> AV18LegConveCodigo ,
                                          String A939LegCatCodigo ,
                                          GXSimpleCollection<String> AV19LegCatCodigo ,
                                          String A1579LegSecCodigo ,
                                          GXSimpleCollection<String> AV20LegSecCodigo ,
                                          String A1578LegPuesCodigo ,
                                          GXSimpleCollection<String> AV21LegPuesCodigo ,
                                          String A1577LegSucCodigo ,
                                          GXSimpleCollection<String> AV22LegSucCodigo ,
                                          int AV18LegConveCodigo_size ,
                                          String AV24ConvenioFiltro ,
                                          int AV19LegCatCodigo_size ,
                                          int AV20LegSecCodigo_size ,
                                          int AV21LegPuesCodigo_size ,
                                          int AV22LegSucCodigo_size ,
                                          java.util.Date A245LegFecIngreso ,
                                          java.util.Date AV9finDeMesFecha ,
                                          java.util.Date A244LegFecEgreso ,
                                          java.util.Date AV8LiqPeriodo ,
                                          byte A235LegClase ,
                                          byte AV14LegClase ,
                                          String A2404LegModTra ,
                                          String AV27LegModTra ,
                                          String A2417LegTipoTarifa ,
                                          String AV28LiqTipoTarifa ,
                                          byte A1818LegEstado ,
                                          int AV15CliCod ,
                                          short AV16EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[7];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT LegSucCodigo, LegPuesCodigo, LegSecCodigo, LegCatCodigo, LegConveCodigo, LegEstado, LegTipoTarifa, LegModTra, LegClase, LegFecEgreso, LegFecIngreso, EmpCod," ;
      scmdbuf += " CliCod, LegNumero FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegFecIngreso <= ?)");
      addWhere(sWhereString, "((LegFecEgreso = DATE '00010101') or LegFecEgreso IS NULL or LegFecEgreso > ?)");
      addWhere(sWhereString, "(LegClase = ?)");
      addWhere(sWhereString, "(LegModTra = ( ?))");
      addWhere(sWhereString, "(LegTipoTarifa = ( ?))");
      addWhere(sWhereString, "(LegEstado = 1)");
      if ( AV18LegConveCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV18LegConveCodigo, "LegConveCodigo IN (", ")")+")");
      }
      if ( GXutil.strcmp(AV24ConvenioFiltro, "Fuera") == 0 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from LegConveCodigo))=0) or LegConveCodigo IS NULL)");
      }
      if ( GXutil.strcmp(AV24ConvenioFiltro, "EnConvenio") == 0 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from LegConveCodigo))=0) and Not LegConveCodigo IS NULL)");
      }
      if ( AV19LegCatCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19LegCatCodigo, "LegCatCodigo IN (", ")")+")");
      }
      if ( AV20LegSecCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20LegSecCodigo, "LegSecCodigo IN (", ")")+")");
      }
      if ( AV21LegPuesCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV21LegPuesCodigo, "LegPuesCodigo IN (", ")")+")");
      }
      if ( AV22LegSucCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22LegSucCodigo, "LegSucCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P027B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(6);
               ((String[]) buf[11])[0] = rslt.getString(7, 1);
               ((String[]) buf[12])[0] = rslt.getString(8, 1);
               ((byte[]) buf[13])[0] = rslt.getByte(9);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(11);
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((int[]) buf[18])[0] = rslt.getInt(13);
               ((int[]) buf[19])[0] = rslt.getInt(14);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[11]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 1);
               }
               return;
      }
   }

}

