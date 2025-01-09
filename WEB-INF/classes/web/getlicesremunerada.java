package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlicesremunerada extends GXProcedure
{
   public getlicesremunerada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlicesremunerada.class ), "" );
   }

   public getlicesremunerada( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      getlicesremunerada.this.aP1 = new boolean[] {false};
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
      getlicesremunerada.this.AV8SitCodigo = aP0;
      getlicesremunerada.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02752 */
      pr_default.execute(0, new Object[] {AV8SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P02752_A16SitCodigo[0] ;
         A739SitLicCuentaTrab = P02752_A739SitLicCuentaTrab[0] ;
         AV9SitLicCuentaTrab = A739SitLicCuentaTrab ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getlicesremunerada.this.AV9SitLicCuentaTrab;
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
      P02752_A16SitCodigo = new String[] {""} ;
      P02752_A739SitLicCuentaTrab = new boolean[] {false} ;
      A16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlicesremunerada__default(),
         new Object[] {
             new Object[] {
            P02752_A16SitCodigo, P02752_A739SitLicCuentaTrab
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SitCodigo ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private boolean AV9SitLicCuentaTrab ;
   private boolean A739SitLicCuentaTrab ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P02752_A16SitCodigo ;
   private boolean[] P02752_A739SitLicCuentaTrab ;
}

final  class getlicesremunerada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02752", "SELECT SitCodigo, SitLicCuentaTrab FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

