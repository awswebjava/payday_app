package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class revalidarimpconceptoerror extends GXProcedure
{
   public revalidarimpconceptoerror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( revalidarimpconceptoerror.class ), "" );
   }

   public revalidarimpconceptoerror( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 )
   {
      revalidarimpconceptoerror.this.AV11CliCod = aP0;
      revalidarimpconceptoerror.this.AV12EmpCod = aP1;
      revalidarimpconceptoerror.this.AV8ImpLiqSec = aP2;
      revalidarimpconceptoerror.this.AV10ImpLiqConExtCod = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00O02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV8ImpLiqSec), AV10ImpLiqConExtCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89ImpLiqConExtCod = P00O02_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P00O02_A88ImpLiqSec[0] ;
         A1EmpCod = P00O02_A1EmpCod[0] ;
         A3CliCod = P00O02_A3CliCod[0] ;
         A641ImpLiqConSisCod = P00O02_A641ImpLiqConSisCod[0] ;
         A702ImpLiqConSisCodYDescrip = P00O02_A702ImpLiqConSisCodYDescrip[0] ;
         A659ImpLiqConError = P00O02_A659ImpLiqConError[0] ;
         GXt_char1 = AV13ConDescrip ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A641ImpLiqConSisCod, GXv_char2) ;
         revalidarimpconceptoerror.this.GXt_char1 = GXv_char2[0] ;
         AV13ConDescrip = GXt_char1 ;
         A702ImpLiqConSisCodYDescrip = GXutil.trim( A641ImpLiqConSisCod) + " - " + GXutil.trim( AV13ConDescrip) ;
         if ( ! (GXutil.strcmp("", A641ImpLiqConSisCod)==0) && ! (GXutil.strcmp("", A659ImpLiqConError)==0) )
         {
            A659ImpLiqConError = "" ;
         }
         /* Using cursor P00O03 */
         pr_default.execute(1, new Object[] {A702ImpLiqConSisCodYDescrip, A659ImpLiqConError, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "revalidarimpconceptoerror");
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
      P00O02_A89ImpLiqConExtCod = new String[] {""} ;
      P00O02_A88ImpLiqSec = new short[1] ;
      P00O02_A1EmpCod = new short[1] ;
      P00O02_A3CliCod = new int[1] ;
      P00O02_A641ImpLiqConSisCod = new String[] {""} ;
      P00O02_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      P00O02_A659ImpLiqConError = new String[] {""} ;
      A89ImpLiqConExtCod = "" ;
      A641ImpLiqConSisCod = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A659ImpLiqConError = "" ;
      AV13ConDescrip = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.revalidarimpconceptoerror__default(),
         new Object[] {
             new Object[] {
            P00O02_A89ImpLiqConExtCod, P00O02_A88ImpLiqSec, P00O02_A1EmpCod, P00O02_A3CliCod, P00O02_A641ImpLiqConSisCod, P00O02_A702ImpLiqConSisCodYDescrip, P00O02_A659ImpLiqConError
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV8ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV10ImpLiqConExtCod ;
   private String scmdbuf ;
   private String A89ImpLiqConExtCod ;
   private String A641ImpLiqConSisCod ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String A659ImpLiqConError ;
   private String AV13ConDescrip ;
   private IDataStoreProvider pr_default ;
   private String[] P00O02_A89ImpLiqConExtCod ;
   private short[] P00O02_A88ImpLiqSec ;
   private short[] P00O02_A1EmpCod ;
   private int[] P00O02_A3CliCod ;
   private String[] P00O02_A641ImpLiqConSisCod ;
   private String[] P00O02_A702ImpLiqConSisCodYDescrip ;
   private String[] P00O02_A659ImpLiqConError ;
}

final  class revalidarimpconceptoerror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O02", "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod, ImpLiqConSisCod, ImpLiqConSisCodYDescrip, ImpLiqConError FROM importacion_conceptos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqConExtCod = ( ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod  FOR UPDATE OF importacion_conceptos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00O03", "SAVEPOINT gxupdate;UPDATE importacion_conceptos SET ImpLiqConSisCodYDescrip=?, ImpLiqConError=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
      }
   }

}

