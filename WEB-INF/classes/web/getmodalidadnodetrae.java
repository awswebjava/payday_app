package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmodalidadnodetrae extends GXProcedure
{
   public getmodalidadnodetrae( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmodalidadnodetrae.class ), "" );
   }

   public getmodalidadnodetrae( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      getmodalidadnodetrae.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      getmodalidadnodetrae.this.AV9MprCod = aP0;
      getmodalidadnodetrae.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P014Q2 */
      pr_default.execute(0, new Object[] {AV9MprCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A18MprCod = P014Q2_A18MprCod[0] ;
         A1071MprNoDetrae = P014Q2_A1071MprNoDetrae[0] ;
         AV13MprNoDetrae = A1071MprNoDetrae ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmodalidadnodetrae.this.AV13MprNoDetrae;
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
      P014Q2_A18MprCod = new String[] {""} ;
      P014Q2_A1071MprNoDetrae = new boolean[] {false} ;
      A18MprCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmodalidadnodetrae__default(),
         new Object[] {
             new Object[] {
            P014Q2_A18MprCod, P014Q2_A1071MprNoDetrae
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9MprCod ;
   private String scmdbuf ;
   private String A18MprCod ;
   private boolean AV13MprNoDetrae ;
   private boolean A1071MprNoDetrae ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P014Q2_A18MprCod ;
   private boolean[] P014Q2_A1071MprNoDetrae ;
}

final  class getmodalidadnodetrae__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014Q2", "SELECT MprCod, MprNoDetrae FROM ModalidadAFIP WHERE MprCod = ( ?) ORDER BY MprCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

