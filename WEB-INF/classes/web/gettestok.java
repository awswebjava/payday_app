package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettestok extends GXProcedure
{
   public gettestok( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettestok.class ), "" );
   }

   public gettestok( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 )
   {
      gettestok.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             boolean[] aP1 )
   {
      gettestok.this.AV9TestNro = aP0;
      gettestok.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01AB2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9TestNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1083TestNro = P01AB2_A1083TestNro[0] ;
         A1084TestOK = P01AB2_A1084TestOK[0] ;
         AV8TestOK = A1084TestOK ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gettestok.this.AV8TestOK;
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
      P01AB2_A1083TestNro = new short[1] ;
      P01AB2_A1084TestOK = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettestok__default(),
         new Object[] {
             new Object[] {
            P01AB2_A1083TestNro, P01AB2_A1084TestOK
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
   private boolean AV8TestOK ;
   private boolean A1084TestOK ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01AB2_A1083TestNro ;
   private boolean[] P01AB2_A1084TestOK ;
}

final  class gettestok__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01AB2", "SELECT TestNro, TestOK FROM Test WHERE TestNro = ? ORDER BY TestNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

