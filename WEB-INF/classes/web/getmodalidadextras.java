package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmodalidadextras extends GXProcedure
{
   public getmodalidadextras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmodalidadextras.class ), "" );
   }

   public getmodalidadextras( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      getmodalidadextras.this.aP1 = new boolean[] {false};
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
      getmodalidadextras.this.AV9MprCod = aP0;
      getmodalidadextras.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CI2 */
      pr_default.execute(0, new Object[] {AV9MprCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A18MprCod = P01CI2_A18MprCod[0] ;
         A1353MprHorasExtras = P01CI2_A1353MprHorasExtras[0] ;
         AV13MprHorasExtras = A1353MprHorasExtras ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmodalidadextras.this.AV13MprHorasExtras;
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
      P01CI2_A18MprCod = new String[] {""} ;
      P01CI2_A1353MprHorasExtras = new boolean[] {false} ;
      A18MprCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmodalidadextras__default(),
         new Object[] {
             new Object[] {
            P01CI2_A18MprCod, P01CI2_A1353MprHorasExtras
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
   private boolean AV13MprHorasExtras ;
   private boolean A1353MprHorasExtras ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CI2_A18MprCod ;
   private boolean[] P01CI2_A1353MprHorasExtras ;
}

final  class getmodalidadextras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CI2", "SELECT MprCod, MprHorasExtras FROM ModalidadAFIP WHERE MprCod = ( ?) ORDER BY MprCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

