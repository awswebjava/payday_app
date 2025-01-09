package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cambiarestadotest extends GXProcedure
{
   public cambiarestadotest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cambiarestadotest.class ), "" );
   }

   public cambiarestadotest( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        boolean aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             boolean aP1 )
   {
      cambiarestadotest.this.AV9TestNro = aP0;
      cambiarestadotest.this.AV8TestOK = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01B52 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9TestNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1083TestNro = P01B52_A1083TestNro[0] ;
         A1084TestOK = P01B52_A1084TestOK[0] ;
         A1085TestFechaHora = P01B52_A1085TestFechaHora[0] ;
         A1091TestError = P01B52_A1091TestError[0] ;
         A1084TestOK = AV8TestOK ;
         A1085TestFechaHora = GXutil.serverNow( context, remoteHandle, pr_default) ;
         if ( AV8TestOK )
         {
            A1091TestError = httpContext.getMessage( "OK", "") ;
         }
         else
         {
            A1091TestError = httpContext.getMessage( "ERROR", "") ;
         }
         /* Using cursor P01B53 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A1084TestOK), A1085TestFechaHora, A1091TestError, Short.valueOf(A1083TestNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "cambiarestadotest");
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
      P01B52_A1083TestNro = new short[1] ;
      P01B52_A1084TestOK = new boolean[] {false} ;
      P01B52_A1085TestFechaHora = new java.util.Date[] {GXutil.nullDate()} ;
      P01B52_A1091TestError = new String[] {""} ;
      A1085TestFechaHora = GXutil.resetTime( GXutil.nullDate() );
      A1091TestError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cambiarestadotest__default(),
         new Object[] {
             new Object[] {
            P01B52_A1083TestNro, P01B52_A1084TestOK, P01B52_A1085TestFechaHora, P01B52_A1091TestError
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9TestNro ;
   private short A1083TestNro ;
   private short Gx_err ;
   private String scmdbuf ;
   private java.util.Date A1085TestFechaHora ;
   private boolean AV8TestOK ;
   private boolean A1084TestOK ;
   private String A1091TestError ;
   private IDataStoreProvider pr_default ;
   private short[] P01B52_A1083TestNro ;
   private boolean[] P01B52_A1084TestOK ;
   private java.util.Date[] P01B52_A1085TestFechaHora ;
   private String[] P01B52_A1091TestError ;
}

final  class cambiarestadotest__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01B52", "SELECT TestNro, TestOK, TestFechaHora, TestError FROM Test WHERE TestNro = ? ORDER BY TestNro  FOR UPDATE OF Test",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01B53", "SAVEPOINT gxupdate;UPDATE Test SET TestOK=?, TestFechaHora=?, TestError=?  WHERE TestNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

