package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresadiasmespara1hora extends GXProcedure
{
   public getempresadiasmespara1hora( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresadiasmespara1hora.class ), "" );
   }

   public getempresadiasmespara1hora( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal[] aP2 )
   {
      getempresadiasmespara1hora.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.math.BigDecimal[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal[] aP2 ,
                             String[] aP3 )
   {
      getempresadiasmespara1hora.this.AV11CliCod = aP0;
      getempresadiasmespara1hora.this.AV12EmpCod = aP1;
      getempresadiasmespara1hora.this.aP2 = aP2;
      getempresadiasmespara1hora.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01CR2_A1EmpCod[0] ;
         A3CliCod = P01CR2_A3CliCod[0] ;
         A1302EmpMesHsPExt = P01CR2_A1302EmpMesHsPExt[0] ;
         n1302EmpMesHsPExt = P01CR2_n1302EmpMesHsPExt[0] ;
         A1303EmpDiaHsPExt = P01CR2_A1303EmpDiaHsPExt[0] ;
         n1303EmpDiaHsPExt = P01CR2_n1303EmpDiaHsPExt[0] ;
         AV13EmpMesHsPExt = A1302EmpMesHsPExt ;
         AV14EmpDiaHsPExt = A1303EmpDiaHsPExt ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresadiasmespara1hora.this.AV13EmpMesHsPExt;
      this.aP3[0] = getempresadiasmespara1hora.this.AV14EmpDiaHsPExt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13EmpMesHsPExt = DecimalUtil.ZERO ;
      AV14EmpDiaHsPExt = "" ;
      scmdbuf = "" ;
      P01CR2_A1EmpCod = new short[1] ;
      P01CR2_A3CliCod = new int[1] ;
      P01CR2_A1302EmpMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CR2_n1302EmpMesHsPExt = new boolean[] {false} ;
      P01CR2_A1303EmpDiaHsPExt = new String[] {""} ;
      P01CR2_n1303EmpDiaHsPExt = new boolean[] {false} ;
      A1302EmpMesHsPExt = DecimalUtil.ZERO ;
      A1303EmpDiaHsPExt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresadiasmespara1hora__default(),
         new Object[] {
             new Object[] {
            P01CR2_A1EmpCod, P01CR2_A3CliCod, P01CR2_A1302EmpMesHsPExt, P01CR2_n1302EmpMesHsPExt, P01CR2_A1303EmpDiaHsPExt, P01CR2_n1303EmpDiaHsPExt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13EmpMesHsPExt ;
   private java.math.BigDecimal A1302EmpMesHsPExt ;
   private String AV14EmpDiaHsPExt ;
   private String scmdbuf ;
   private String A1303EmpDiaHsPExt ;
   private boolean n1302EmpMesHsPExt ;
   private boolean n1303EmpDiaHsPExt ;
   private String[] aP3 ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01CR2_A1EmpCod ;
   private int[] P01CR2_A3CliCod ;
   private java.math.BigDecimal[] P01CR2_A1302EmpMesHsPExt ;
   private boolean[] P01CR2_n1302EmpMesHsPExt ;
   private String[] P01CR2_A1303EmpDiaHsPExt ;
   private boolean[] P01CR2_n1303EmpDiaHsPExt ;
}

final  class getempresadiasmespara1hora__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CR2", "SELECT EmpCod, CliCod, EmpMesHsPExt, EmpDiaHsPExt FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
               return;
      }
   }

}

