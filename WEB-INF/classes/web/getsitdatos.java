package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsitdatos extends GXProcedure
{
   public getsitdatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsitdatos.class ), "" );
   }

   public getsitdatos( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( String aP0 ,
                           byte[] aP1 )
   {
      getsitdatos.this.aP2 = new byte[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        byte[] aP1 ,
                        byte[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             byte[] aP1 ,
                             byte[] aP2 )
   {
      getsitdatos.this.AV8sitCodigo = aP0;
      getsitdatos.this.aP1 = aP1;
      getsitdatos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01EO2 */
      pr_default.execute(0, new Object[] {AV8sitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P01EO2_A16SitCodigo[0] ;
         A897SitLicMesesProm = P01EO2_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = P01EO2_A898SitLicMesesProm2[0] ;
         AV9SitLicMesesProm = A897SitLicMesesProm ;
         AV10SitLicMesesProm2 = A898SitLicMesesProm2 ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsitdatos.this.AV9SitLicMesesProm;
      this.aP2[0] = getsitdatos.this.AV10SitLicMesesProm2;
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
      P01EO2_A16SitCodigo = new String[] {""} ;
      P01EO2_A897SitLicMesesProm = new byte[1] ;
      P01EO2_A898SitLicMesesProm2 = new byte[1] ;
      A16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsitdatos__default(),
         new Object[] {
             new Object[] {
            P01EO2_A16SitCodigo, P01EO2_A897SitLicMesesProm, P01EO2_A898SitLicMesesProm2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9SitLicMesesProm ;
   private byte AV10SitLicMesesProm2 ;
   private byte A897SitLicMesesProm ;
   private byte A898SitLicMesesProm2 ;
   private short Gx_err ;
   private String AV8sitCodigo ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private byte[] aP2 ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01EO2_A16SitCodigo ;
   private byte[] P01EO2_A897SitLicMesesProm ;
   private byte[] P01EO2_A898SitLicMesesProm2 ;
}

final  class getsitdatos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EO2", "SELECT SitCodigo, SitLicMesesProm, SitLicMesesProm2 FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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

