package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsituacionpordescrip extends GXProcedure
{
   public getsituacionpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsituacionpordescrip.class ), "" );
   }

   public getsituacionpordescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getsituacionpordescrip.this.aP2 = new boolean[] {false};
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
      getsituacionpordescrip.this.AV9SitDescrip = aP0;
      getsituacionpordescrip.this.aP1 = aP1;
      getsituacionpordescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002M2 */
      pr_default.execute(0, new Object[] {AV9SitDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A685SitDescripSinAc = P002M2_A685SitDescripSinAc[0] ;
         A16SitCodigo = P002M2_A16SitCodigo[0] ;
         AV8SitCodigo = A16SitCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsituacionpordescrip.this.AV8SitCodigo;
      this.aP2[0] = getsituacionpordescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SitCodigo = "" ;
      scmdbuf = "" ;
      P002M2_A685SitDescripSinAc = new String[] {""} ;
      P002M2_A16SitCodigo = new String[] {""} ;
      A685SitDescripSinAc = "" ;
      A16SitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsituacionpordescrip__default(),
         new Object[] {
             new Object[] {
            P002M2_A685SitDescripSinAc, P002M2_A16SitCodigo
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
   private String A685SitDescripSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002M2_A685SitDescripSinAc ;
   private String[] P002M2_A16SitCodigo ;
}

final  class getsituacionpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002M2", "SELECT SitDescripSinAc, SitCodigo FROM Estado WHERE SitDescripSinAc = ( ?) ORDER BY SitCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

