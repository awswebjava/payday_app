package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdescripexternaimportacionafip extends GXProcedure
{
   public getdescripexternaimportacionafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdescripexternaimportacionafip.class ), "" );
   }

   public getdescripexternaimportacionafip( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 )
   {
      getdescripexternaimportacionafip.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getdescripexternaimportacionafip.this.AV8CliCod = aP0;
      getdescripexternaimportacionafip.this.AV11EmpCod = aP1;
      getdescripexternaimportacionafip.this.AV9ImpLiqSec = aP2;
      getdescripexternaimportacionafip.this.AV10ImpLiqConExtCod = aP3;
      getdescripexternaimportacionafip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01LY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod), Short.valueOf(AV9ImpLiqSec), AV10ImpLiqConExtCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89ImpLiqConExtCod = P01LY2_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P01LY2_A88ImpLiqSec[0] ;
         A1EmpCod = P01LY2_A1EmpCod[0] ;
         A3CliCod = P01LY2_A3CliCod[0] ;
         A640ImpLiqConExtDescrip = P01LY2_A640ImpLiqConExtDescrip[0] ;
         AV12ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getdescripexternaimportacionafip.this.AV12ImpLiqConExtDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ImpLiqConExtDescrip = "" ;
      scmdbuf = "" ;
      P01LY2_A89ImpLiqConExtCod = new String[] {""} ;
      P01LY2_A88ImpLiqSec = new short[1] ;
      P01LY2_A1EmpCod = new short[1] ;
      P01LY2_A3CliCod = new int[1] ;
      P01LY2_A640ImpLiqConExtDescrip = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      A640ImpLiqConExtDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdescripexternaimportacionafip__default(),
         new Object[] {
             new Object[] {
            P01LY2_A89ImpLiqConExtCod, P01LY2_A88ImpLiqSec, P01LY2_A1EmpCod, P01LY2_A3CliCod, P01LY2_A640ImpLiqConExtDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ImpLiqConExtCod ;
   private String scmdbuf ;
   private String A89ImpLiqConExtCod ;
   private String AV12ImpLiqConExtDescrip ;
   private String A640ImpLiqConExtDescrip ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LY2_A89ImpLiqConExtCod ;
   private short[] P01LY2_A88ImpLiqSec ;
   private short[] P01LY2_A1EmpCod ;
   private int[] P01LY2_A3CliCod ;
   private String[] P01LY2_A640ImpLiqConExtDescrip ;
}

final  class getdescripexternaimportacionafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LY2", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConExtDescrip FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

