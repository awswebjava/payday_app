package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvemeshspext extends GXProcedure
{
   public getconvemeshspext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvemeshspext.class ), "" );
   }

   public getconvemeshspext( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           String aP2 )
   {
      getconvemeshspext.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getconvemeshspext.this.AV11CliCod = aP0;
      getconvemeshspext.this.AV10CliPaiConve = aP1;
      getconvemeshspext.this.AV9CliConvenio = aP2;
      getconvemeshspext.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01XG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01XG2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01XG2_A1564CliPaiConve[0] ;
         A3CliCod = P01XG2_A3CliCod[0] ;
         A1269ConveMesHsPExt = P01XG2_A1269ConveMesHsPExt[0] ;
         A1575CliConveVig = P01XG2_A1575CliConveVig[0] ;
         AV8ConveMesHsPExt = A1269ConveMesHsPExt ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getconvemeshspext.this.AV8ConveMesHsPExt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConveMesHsPExt = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01XG2_A1565CliConvenio = new String[] {""} ;
      P01XG2_A1564CliPaiConve = new short[1] ;
      P01XG2_A3CliCod = new int[1] ;
      P01XG2_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01XG2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1565CliConvenio = "" ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1575CliConveVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvemeshspext__default(),
         new Object[] {
             new Object[] {
            P01XG2_A1565CliConvenio, P01XG2_A1564CliPaiConve, P01XG2_A3CliCod, P01XG2_A1269ConveMesHsPExt, P01XG2_A1575CliConveVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8ConveMesHsPExt ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private String AV9CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date A1575CliConveVig ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01XG2_A1565CliConvenio ;
   private short[] P01XG2_A1564CliPaiConve ;
   private int[] P01XG2_A3CliCod ;
   private java.math.BigDecimal[] P01XG2_A1269ConveMesHsPExt ;
   private java.util.Date[] P01XG2_A1575CliConveVig ;
}

final  class getconvemeshspext__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XG2", "SELECT CliConvenio, CliPaiConve, CliCod, ConveMesHsPExt, CliConveVig FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

