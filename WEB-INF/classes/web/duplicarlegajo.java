package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class duplicarlegajo extends GXProcedure
{
   public duplicarlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( duplicarlegajo.class ), "" );
   }

   public duplicarlegajo( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      duplicarlegajo.this.AV9CliCod = aP0;
      duplicarlegajo.this.AV8EmpCod = aP1;
      duplicarlegajo.this.AV10LegNumero = aP2;
      duplicarlegajo.this.AV16cant = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01OR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01OR2_A6LegNumero[0] ;
         A1EmpCod = P01OR2_A1EmpCod[0] ;
         A3CliCod = P01OR2_A3CliCod[0] ;
         A239LegCUIL = P01OR2_A239LegCUIL[0] ;
         A93LegId = P01OR2_A93LegId[0] ;
         n93LegId = P01OR2_n93LegId[0] ;
         A263LegSexo = P01OR2_A263LegSexo[0] ;
         n263LegSexo = P01OR2_n263LegSexo[0] ;
         A230LegApellido = P01OR2_A230LegApellido[0] ;
         A251LegNombre = P01OR2_A251LegNombre[0] ;
         A246LegFecNac = P01OR2_A246LegFecNac[0] ;
         A242LegDomici = P01OR2_A242LegDomici[0] ;
         A245LegFecIngreso = P01OR2_A245LegFecIngreso[0] ;
         A939LegCatCodigo = P01OR2_A939LegCatCodigo[0] ;
         n939LegCatCodigo = P01OR2_n939LegCatCodigo[0] ;
         A1579LegSecCodigo = P01OR2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01OR2_n1579LegSecCodigo[0] ;
         A1581LegLpgCodigo = P01OR2_A1581LegLpgCodigo[0] ;
         n1581LegLpgCodigo = P01OR2_n1581LegLpgCodigo[0] ;
         A235LegClase = P01OR2_A235LegClase[0] ;
         A248LegFormaPago = P01OR2_A248LegFormaPago[0] ;
         A1582LegBanCod = P01OR2_A1582LegBanCod[0] ;
         n1582LegBanCod = P01OR2_n1582LegBanCod[0] ;
         A231LegBanSuc = P01OR2_A231LegBanSuc[0] ;
         n231LegBanSuc = P01OR2_n231LegBanSuc[0] ;
         A910LegSinCod = P01OR2_A910LegSinCod[0] ;
         n910LegSinCod = P01OR2_n910LegSinCod[0] ;
         A1580LegOsoCod = P01OR2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01OR2_n1580LegOsoCod[0] ;
         A15LegActCodigo = P01OR2_A15LegActCodigo[0] ;
         n15LegActCodigo = P01OR2_n15LegActCodigo[0] ;
         A20ZonCod = P01OR2_A20ZonCod[0] ;
         n20ZonCod = P01OR2_n20ZonCod[0] ;
         A17CondiCodigo = P01OR2_A17CondiCodigo[0] ;
         n17CondiCodigo = P01OR2_n17CondiCodigo[0] ;
         A19SinieCodigo = P01OR2_A19SinieCodigo[0] ;
         n19SinieCodigo = P01OR2_n19SinieCodigo[0] ;
         A937LegConveCodigo = P01OR2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P01OR2_n937LegConveCodigo[0] ;
         A264LegSueldoFuera = P01OR2_A264LegSueldoFuera[0] ;
         A234LegCBU = P01OR2_A234LegCBU[0] ;
         n234LegCBU = P01OR2_n234LegCBU[0] ;
         A877LegAgenReten = P01OR2_A877LegAgenReten[0] ;
         A244LegFecEgreso = P01OR2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P01OR2_n244LegFecEgreso[0] ;
         AV13LegCUIL = A239LegCUIL ;
         AV12LegId = A93LegId ;
         AV15LegIdNum = (short)(GXutil.lval( AV12LegId)) ;
         AV14i = (short)(1) ;
         while ( AV14i <= AV16cant )
         {
            GXv_int1[0] = AV11auxLegNumero ;
            new web.obtienesiguientelegajo(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, GXv_int1) ;
            duplicarlegajo.this.AV11auxLegNumero = GXv_int1[0] ;
            AV13LegCUIL = (long)(AV13LegCUIL+1) ;
            AV15LegIdNum = (short)(AV15LegIdNum+1) ;
            AV12LegId = GXutil.trim( GXutil.str( AV15LegIdNum, 4, 0)) ;
            new web.newlegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, AV11auxLegNumero, A263LegSexo, A230LegApellido, A251LegNombre, AV12LegId, "", A246LegFecNac, AV13LegCUIL, A242LegDomici, A245LegFecIngreso, A939LegCatCodigo, A1579LegSecCodigo, A1581LegLpgCodigo, A235LegClase, A248LegFormaPago, A1582LegBanCod, A231LegBanSuc, A910LegSinCod, A1580LegOsoCod, "", A15LegActCodigo, A20ZonCod, "", A17CondiCodigo, A19SinieCodigo, A937LegConveCodigo, A264LegSueldoFuera, A234LegCBU, "", "", "", A877LegAgenReten, A244LegFecEgreso) ;
            AV14i = (short)(AV14i+1) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01OR2_A6LegNumero = new int[1] ;
      P01OR2_A1EmpCod = new short[1] ;
      P01OR2_A3CliCod = new int[1] ;
      P01OR2_A239LegCUIL = new long[1] ;
      P01OR2_A93LegId = new String[] {""} ;
      P01OR2_n93LegId = new boolean[] {false} ;
      P01OR2_A263LegSexo = new byte[1] ;
      P01OR2_n263LegSexo = new boolean[] {false} ;
      P01OR2_A230LegApellido = new String[] {""} ;
      P01OR2_A251LegNombre = new String[] {""} ;
      P01OR2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P01OR2_A242LegDomici = new String[] {""} ;
      P01OR2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01OR2_A939LegCatCodigo = new String[] {""} ;
      P01OR2_n939LegCatCodigo = new boolean[] {false} ;
      P01OR2_A1579LegSecCodigo = new String[] {""} ;
      P01OR2_n1579LegSecCodigo = new boolean[] {false} ;
      P01OR2_A1581LegLpgCodigo = new String[] {""} ;
      P01OR2_n1581LegLpgCodigo = new boolean[] {false} ;
      P01OR2_A235LegClase = new byte[1] ;
      P01OR2_A248LegFormaPago = new byte[1] ;
      P01OR2_A1582LegBanCod = new String[] {""} ;
      P01OR2_n1582LegBanCod = new boolean[] {false} ;
      P01OR2_A231LegBanSuc = new String[] {""} ;
      P01OR2_n231LegBanSuc = new boolean[] {false} ;
      P01OR2_A910LegSinCod = new String[] {""} ;
      P01OR2_n910LegSinCod = new boolean[] {false} ;
      P01OR2_A1580LegOsoCod = new String[] {""} ;
      P01OR2_n1580LegOsoCod = new boolean[] {false} ;
      P01OR2_A15LegActCodigo = new String[] {""} ;
      P01OR2_n15LegActCodigo = new boolean[] {false} ;
      P01OR2_A20ZonCod = new String[] {""} ;
      P01OR2_n20ZonCod = new boolean[] {false} ;
      P01OR2_A17CondiCodigo = new short[1] ;
      P01OR2_n17CondiCodigo = new boolean[] {false} ;
      P01OR2_A19SinieCodigo = new String[] {""} ;
      P01OR2_n19SinieCodigo = new boolean[] {false} ;
      P01OR2_A937LegConveCodigo = new String[] {""} ;
      P01OR2_n937LegConveCodigo = new boolean[] {false} ;
      P01OR2_A264LegSueldoFuera = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01OR2_A234LegCBU = new String[] {""} ;
      P01OR2_n234LegCBU = new boolean[] {false} ;
      P01OR2_A877LegAgenReten = new boolean[] {false} ;
      P01OR2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01OR2_n244LegFecEgreso = new boolean[] {false} ;
      A93LegId = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A242LegDomici = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A939LegCatCodigo = "" ;
      A1579LegSecCodigo = "" ;
      A1581LegLpgCodigo = "" ;
      A1582LegBanCod = "" ;
      A231LegBanSuc = "" ;
      A910LegSinCod = "" ;
      A1580LegOsoCod = "" ;
      A15LegActCodigo = "" ;
      A20ZonCod = "" ;
      A19SinieCodigo = "" ;
      A937LegConveCodigo = "" ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      A234LegCBU = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      AV12LegId = "" ;
      GXv_int1 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.duplicarlegajo__default(),
         new Object[] {
             new Object[] {
            P01OR2_A6LegNumero, P01OR2_A1EmpCod, P01OR2_A3CliCod, P01OR2_A239LegCUIL, P01OR2_A93LegId, P01OR2_n93LegId, P01OR2_A263LegSexo, P01OR2_n263LegSexo, P01OR2_A230LegApellido, P01OR2_A251LegNombre,
            P01OR2_A246LegFecNac, P01OR2_A242LegDomici, P01OR2_A245LegFecIngreso, P01OR2_A939LegCatCodigo, P01OR2_n939LegCatCodigo, P01OR2_A1579LegSecCodigo, P01OR2_n1579LegSecCodigo, P01OR2_A1581LegLpgCodigo, P01OR2_n1581LegLpgCodigo, P01OR2_A235LegClase,
            P01OR2_A248LegFormaPago, P01OR2_A1582LegBanCod, P01OR2_n1582LegBanCod, P01OR2_A231LegBanSuc, P01OR2_n231LegBanSuc, P01OR2_A910LegSinCod, P01OR2_n910LegSinCod, P01OR2_A1580LegOsoCod, P01OR2_n1580LegOsoCod, P01OR2_A15LegActCodigo,
            P01OR2_n15LegActCodigo, P01OR2_A20ZonCod, P01OR2_n20ZonCod, P01OR2_A17CondiCodigo, P01OR2_n17CondiCodigo, P01OR2_A19SinieCodigo, P01OR2_n19SinieCodigo, P01OR2_A937LegConveCodigo, P01OR2_n937LegConveCodigo, P01OR2_A264LegSueldoFuera,
            P01OR2_A234LegCBU, P01OR2_n234LegCBU, P01OR2_A877LegAgenReten, P01OR2_A244LegFecEgreso, P01OR2_n244LegFecEgreso
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A263LegSexo ;
   private byte A235LegClase ;
   private byte A248LegFormaPago ;
   private short AV8EmpCod ;
   private short AV16cant ;
   private short A1EmpCod ;
   private short A17CondiCodigo ;
   private short AV15LegIdNum ;
   private short AV14i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV11auxLegNumero ;
   private int GXv_int1[] ;
   private long A239LegCUIL ;
   private long AV13LegCUIL ;
   private java.math.BigDecimal A264LegSueldoFuera ;
   private String scmdbuf ;
   private String A93LegId ;
   private String A939LegCatCodigo ;
   private String A1579LegSecCodigo ;
   private String A1581LegLpgCodigo ;
   private String A1582LegBanCod ;
   private String A910LegSinCod ;
   private String A1580LegOsoCod ;
   private String A15LegActCodigo ;
   private String A20ZonCod ;
   private String A19SinieCodigo ;
   private String A937LegConveCodigo ;
   private String AV12LegId ;
   private java.util.Date A246LegFecNac ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n93LegId ;
   private boolean n263LegSexo ;
   private boolean n939LegCatCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n1581LegLpgCodigo ;
   private boolean n1582LegBanCod ;
   private boolean n231LegBanSuc ;
   private boolean n910LegSinCod ;
   private boolean n1580LegOsoCod ;
   private boolean n15LegActCodigo ;
   private boolean n20ZonCod ;
   private boolean n17CondiCodigo ;
   private boolean n19SinieCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n234LegCBU ;
   private boolean A877LegAgenReten ;
   private boolean n244LegFecEgreso ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private String A242LegDomici ;
   private String A231LegBanSuc ;
   private String A234LegCBU ;
   private IDataStoreProvider pr_default ;
   private int[] P01OR2_A6LegNumero ;
   private short[] P01OR2_A1EmpCod ;
   private int[] P01OR2_A3CliCod ;
   private long[] P01OR2_A239LegCUIL ;
   private String[] P01OR2_A93LegId ;
   private boolean[] P01OR2_n93LegId ;
   private byte[] P01OR2_A263LegSexo ;
   private boolean[] P01OR2_n263LegSexo ;
   private String[] P01OR2_A230LegApellido ;
   private String[] P01OR2_A251LegNombre ;
   private java.util.Date[] P01OR2_A246LegFecNac ;
   private String[] P01OR2_A242LegDomici ;
   private java.util.Date[] P01OR2_A245LegFecIngreso ;
   private String[] P01OR2_A939LegCatCodigo ;
   private boolean[] P01OR2_n939LegCatCodigo ;
   private String[] P01OR2_A1579LegSecCodigo ;
   private boolean[] P01OR2_n1579LegSecCodigo ;
   private String[] P01OR2_A1581LegLpgCodigo ;
   private boolean[] P01OR2_n1581LegLpgCodigo ;
   private byte[] P01OR2_A235LegClase ;
   private byte[] P01OR2_A248LegFormaPago ;
   private String[] P01OR2_A1582LegBanCod ;
   private boolean[] P01OR2_n1582LegBanCod ;
   private String[] P01OR2_A231LegBanSuc ;
   private boolean[] P01OR2_n231LegBanSuc ;
   private String[] P01OR2_A910LegSinCod ;
   private boolean[] P01OR2_n910LegSinCod ;
   private String[] P01OR2_A1580LegOsoCod ;
   private boolean[] P01OR2_n1580LegOsoCod ;
   private String[] P01OR2_A15LegActCodigo ;
   private boolean[] P01OR2_n15LegActCodigo ;
   private String[] P01OR2_A20ZonCod ;
   private boolean[] P01OR2_n20ZonCod ;
   private short[] P01OR2_A17CondiCodigo ;
   private boolean[] P01OR2_n17CondiCodigo ;
   private String[] P01OR2_A19SinieCodigo ;
   private boolean[] P01OR2_n19SinieCodigo ;
   private String[] P01OR2_A937LegConveCodigo ;
   private boolean[] P01OR2_n937LegConveCodigo ;
   private java.math.BigDecimal[] P01OR2_A264LegSueldoFuera ;
   private String[] P01OR2_A234LegCBU ;
   private boolean[] P01OR2_n234LegCBU ;
   private boolean[] P01OR2_A877LegAgenReten ;
   private java.util.Date[] P01OR2_A244LegFecEgreso ;
   private boolean[] P01OR2_n244LegFecEgreso ;
}

final  class duplicarlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OR2", "SELECT LegNumero, EmpCod, CliCod, LegCUIL, LegId, LegSexo, LegApellido, LegNombre, LegFecNac, LegDomici, LegFecIngreso, LegCatCodigo, LegSecCodigo, LegLpgCodigo, LegClase, LegFormaPago, LegBanCod, LegBanSuc, LegSinCod, LegOsoCod, LegActCodigo, ZonCod, CondiCodigo, SinieCodigo, LegConveCodigo, LegSueldoFuera, LegCBU, LegAgenReten, LegFecEgreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(11);
               ((String[]) buf[13])[0] = rslt.getString(12, 40);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((byte[]) buf[19])[0] = rslt.getByte(15);
               ((byte[]) buf[20])[0] = rslt.getByte(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 6);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(19, 20);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(21, 8);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((short[]) buf[33])[0] = rslt.getShort(23);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getString(24, 4);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(26,2);
               ((String[]) buf[40])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((boolean[]) buf[42])[0] = rslt.getBoolean(28);
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDate(29);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
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
      }
   }

}

