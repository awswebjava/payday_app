package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituaciondescrip extends GXProcedure
{
   public getsituaciondescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituaciondescrip.class ), "" );
   }

   public getsituaciondescrip( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getsituaciondescrip.this.aP1 = new String[] {""};
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
      getsituaciondescrip.this.AV8SitCodigo = aP0;
      getsituaciondescrip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P001U2 */
      pr_default.execute(0, new Object[] {AV8SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P001U2_A16SitCodigo[0] ;
         A334SitDescrip = P001U2_A334SitDescrip[0] ;
         AV9SitDescrip = A334SitDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsituaciondescrip.this.AV9SitDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SitDescrip = "" ;
      scmdbuf = "" ;
      P001U2_A16SitCodigo = new String[] {""} ;
      P001U2_A334SitDescrip = new String[] {""} ;
      A16SitCodigo = "" ;
      A334SitDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituaciondescrip__default(),
         new Object[] {
             new Object[] {
            P001U2_A16SitCodigo, P001U2_A334SitDescrip
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
   private String AV9SitDescrip ;
   private String A334SitDescrip ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P001U2_A16SitCodigo ;
   private String[] P001U2_A334SitDescrip ;
}

final  class getsituaciondescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001U2", "SELECT SitCodigo, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

