package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmetaparmvalue extends GXProcedure
{
   public getmetaparmvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmetaparmvalue.class ), "" );
   }

   public getmetaparmvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getmetaparmvalue.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getmetaparmvalue.this.AV8MetaParmCod = aP0;
      getmetaparmvalue.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MW2 */
      pr_default.execute(0, new Object[] {AV8MetaParmCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1790MetaParmCod = P01MW2_A1790MetaParmCod[0] ;
         A1791MetaParmValue = P01MW2_A1791MetaParmValue[0] ;
         AV9MetaParmValue = A1791MetaParmValue ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmetaparmvalue.this.AV9MetaParmValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MetaParmValue = "" ;
      scmdbuf = "" ;
      P01MW2_A1790MetaParmCod = new String[] {""} ;
      P01MW2_A1791MetaParmValue = new String[] {""} ;
      A1790MetaParmCod = "" ;
      A1791MetaParmValue = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmetaparmvalue__default(),
         new Object[] {
             new Object[] {
            P01MW2_A1790MetaParmCod, P01MW2_A1791MetaParmValue
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8MetaParmCod ;
   private String scmdbuf ;
   private String A1790MetaParmCod ;
   private String AV9MetaParmValue ;
   private String A1791MetaParmValue ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MW2_A1790MetaParmCod ;
   private String[] P01MW2_A1791MetaParmValue ;
}

final  class getmetaparmvalue__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MW2", "SELECT MetaParmCod, MetaParmValue FROM MetaParam WHERE MetaParmCod = ( ?) ORDER BY MetaParmCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setString(1, (String)parms[0], 30);
               return;
      }
   }

}

