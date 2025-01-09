package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituacion extends GXProcedure
{
   public getsituacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituacion.class ), "" );
   }

   public getsituacion( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getsituacion.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getsituacion.this.AV8SitCodigo = aP0;
      getsituacion.this.aP1 = aP1;
      getsituacion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00AD2 */
      pr_default.execute(0, new Object[] {AV8SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A16SitCodigo = P00AD2_A16SitCodigo[0] ;
         A334SitDescrip = P00AD2_A334SitDescrip[0] ;
         AV9SitDescrip = A334SitDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsituacion.this.AV9SitDescrip;
      this.aP2[0] = getsituacion.this.AV11existe;
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
      P00AD2_A16SitCodigo = new String[] {""} ;
      P00AD2_A334SitDescrip = new String[] {""} ;
      A16SitCodigo = "" ;
      A334SitDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituacion__default(),
         new Object[] {
             new Object[] {
            P00AD2_A16SitCodigo, P00AD2_A334SitDescrip
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
   private boolean AV11existe ;
   private String AV9SitDescrip ;
   private String A334SitDescrip ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AD2_A16SitCodigo ;
   private String[] P00AD2_A334SitDescrip ;
}

final  class getsituacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AD2", "SELECT SitCodigo, SitDescrip FROM Estado WHERE SitCodigo = ( ?) ORDER BY SitCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

