package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvediasmespara1hora extends GXProcedure
{
   public getconvediasmespara1hora( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvediasmespara1hora.class ), "" );
   }

   public getconvediasmespara1hora( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      getconvediasmespara1hora.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 )
   {
      getconvediasmespara1hora.this.AV11CliCod = aP0;
      getconvediasmespara1hora.this.AV17EmpCod = aP1;
      getconvediasmespara1hora.this.AV18LegNumero = aP2;
      getconvediasmespara1hora.this.AV8PaiCod = aP3;
      getconvediasmespara1hora.this.AV12ConveCodigo = aP4;
      getconvediasmespara1hora.this.AV16LiqPeriodo = aP5;
      getconvediasmespara1hora.this.aP6 = aP6;
      getconvediasmespara1hora.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV15CliConveVer ;
      new web.getversiondelegajo(remoteHandle, context).execute( AV11CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
      getconvediasmespara1hora.this.AV15CliConveVer = GXv_int1[0] ;
      /* Using cursor P01CQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliConveVer), Short.valueOf(AV8PaiCod), AV12ConveCodigo, AV16LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01CQ2_A3CliCod[0] ;
         A1564CliPaiConve = P01CQ2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01CQ2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01CQ2_A1575CliConveVig[0] ;
         A1269ConveMesHsPExt = P01CQ2_A1269ConveMesHsPExt[0] ;
         A1270ConveDiaHsPExt = P01CQ2_A1270ConveDiaHsPExt[0] ;
         n1270ConveDiaHsPExt = P01CQ2_n1270ConveDiaHsPExt[0] ;
         AV13ConveMesHsPExt = A1269ConveMesHsPExt ;
         AV14ConveDiaHsPExt = A1270ConveDiaHsPExt ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getconvediasmespara1hora.this.AV13ConveMesHsPExt;
      this.aP7[0] = getconvediasmespara1hora.this.AV14ConveDiaHsPExt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ConveMesHsPExt = DecimalUtil.ZERO ;
      AV14ConveDiaHsPExt = "" ;
      GXv_int1 = new int[1] ;
      scmdbuf = "" ;
      P01CQ2_A3CliCod = new int[1] ;
      P01CQ2_A1564CliPaiConve = new short[1] ;
      P01CQ2_A1565CliConvenio = new String[] {""} ;
      P01CQ2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01CQ2_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CQ2_A1270ConveDiaHsPExt = new String[] {""} ;
      P01CQ2_n1270ConveDiaHsPExt = new boolean[] {false} ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvediasmespara1hora__default(),
         new Object[] {
             new Object[] {
            P01CQ2_A3CliCod, P01CQ2_A1564CliPaiConve, P01CQ2_A1565CliConvenio, P01CQ2_A1575CliConveVig, P01CQ2_A1269ConveMesHsPExt, P01CQ2_A1270ConveDiaHsPExt, P01CQ2_n1270ConveDiaHsPExt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short AV8PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV18LegNumero ;
   private int AV15CliConveVer ;
   private int GXv_int1[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13ConveMesHsPExt ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private String AV12ConveCodigo ;
   private String AV14ConveDiaHsPExt ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1270ConveDiaHsPExt ;
   private java.util.Date AV16LiqPeriodo ;
   private java.util.Date A1575CliConveVig ;
   private boolean n1270ConveDiaHsPExt ;
   private String[] aP7 ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CQ2_A3CliCod ;
   private short[] P01CQ2_A1564CliPaiConve ;
   private String[] P01CQ2_A1565CliConvenio ;
   private java.util.Date[] P01CQ2_A1575CliConveVig ;
   private java.math.BigDecimal[] P01CQ2_A1269ConveMesHsPExt ;
   private String[] P01CQ2_A1270ConveDiaHsPExt ;
   private boolean[] P01CQ2_n1270ConveDiaHsPExt ;
}

final  class getconvediasmespara1hora__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CQ2", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveMesHsPExt, ConveDiaHsPExt FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig <= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

