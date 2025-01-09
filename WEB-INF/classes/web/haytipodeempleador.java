package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haytipodeempleador extends GXProcedure
{
   public haytipodeempleador( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haytipodeempleador.class ), "" );
   }

   public haytipodeempleador( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      haytipodeempleador.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      haytipodeempleador.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00MW2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A45TipEmpleCod = P00MW2_A45TipEmpleCod[0] ;
         AV8hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = haytipodeempleador.this.AV8hay;
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
      P00MW2_A45TipEmpleCod = new String[] {""} ;
      A45TipEmpleCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haytipodeempleador__default(),
         new Object[] {
             new Object[] {
            P00MW2_A45TipEmpleCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String scmdbuf ;
   private String A45TipEmpleCod ;
   private boolean AV8hay ;
   private boolean[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MW2_A45TipEmpleCod ;
}

final  class haytipodeempleador__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MW2", "SELECT TipEmpleCod FROM TipoEmpleador ORDER BY TipEmpleCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

