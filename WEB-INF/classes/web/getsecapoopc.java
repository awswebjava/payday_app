package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsecapoopc extends GXProcedure
{
   public getsecapoopc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsecapoopc.class ), "" );
   }

   public getsecapoopc( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      getsecapoopc.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      getsecapoopc.this.AV8CliCod = aP0;
      getsecapoopc.this.AV9SecCodigo = aP1;
      getsecapoopc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9SecCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13SecCodigo = P02BL2_A13SecCodigo[0] ;
         A3CliCod = P02BL2_A3CliCod[0] ;
         A2308SecApoOpc = P02BL2_A2308SecApoOpc[0] ;
         AV10SecApoOpc = A2308SecApoOpc ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsecapoopc.this.AV10SecApoOpc;
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
      P02BL2_A13SecCodigo = new String[] {""} ;
      P02BL2_A3CliCod = new int[1] ;
      P02BL2_A2308SecApoOpc = new boolean[] {false} ;
      A13SecCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsecapoopc__default(),
         new Object[] {
             new Object[] {
            P02BL2_A13SecCodigo, P02BL2_A3CliCod, P02BL2_A2308SecApoOpc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9SecCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private boolean AV10SecApoOpc ;
   private boolean A2308SecApoOpc ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02BL2_A13SecCodigo ;
   private int[] P02BL2_A3CliCod ;
   private boolean[] P02BL2_A2308SecApoOpc ;
}

final  class getsecapoopc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BL2", "SELECT SecCodigo, CliCod, SecApoOpc FROM Seccion WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

