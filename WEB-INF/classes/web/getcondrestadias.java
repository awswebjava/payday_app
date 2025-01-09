package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondrestadias extends GXProcedure
{
   public getcondrestadias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondrestadias.class ), "" );
   }

   public getcondrestadias( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      getcondrestadias.this.aP1 = new boolean[] {false};
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
      getcondrestadias.this.AV9ConCondicion = aP0;
      getcondrestadias.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZP2 */
      pr_default.execute(0, new Object[] {AV9ConCondicion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A953ConCondicion = P01ZP2_A953ConCondicion[0] ;
         A2133CondRestaDias = P01ZP2_A2133CondRestaDias[0] ;
         AV8CondRestaDias = A2133CondRestaDias ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcondrestadias.this.AV8CondRestaDias;
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
      P01ZP2_A953ConCondicion = new String[] {""} ;
      P01ZP2_A2133CondRestaDias = new boolean[] {false} ;
      A953ConCondicion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondrestadias__default(),
         new Object[] {
             new Object[] {
            P01ZP2_A953ConCondicion, P01ZP2_A2133CondRestaDias
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9ConCondicion ;
   private String scmdbuf ;
   private String A953ConCondicion ;
   private boolean AV8CondRestaDias ;
   private boolean A2133CondRestaDias ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZP2_A953ConCondicion ;
   private boolean[] P01ZP2_A2133CondRestaDias ;
}

final  class getcondrestadias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZP2", "SELECT ConCondicion, CondRestaDias FROM Condiciones_concepto WHERE ConCondicion = ( ?) ORDER BY ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

