package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmodalidadparcial extends GXProcedure
{
   public getmodalidadparcial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmodalidadparcial.class ), "" );
   }

   public getmodalidadparcial( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      getmodalidadparcial.this.aP1 = new boolean[] {false};
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
      getmodalidadparcial.this.AV9MprCod = aP0;
      getmodalidadparcial.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P013E2 */
      pr_default.execute(0, new Object[] {AV9MprCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A18MprCod = P013E2_A18MprCod[0] ;
         A1024MprEsParcial = P013E2_A1024MprEsParcial[0] ;
         AV12MprEsParcial = A1024MprEsParcial ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmodalidadparcial.this.AV12MprEsParcial;
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
      P013E2_A18MprCod = new String[] {""} ;
      P013E2_A1024MprEsParcial = new boolean[] {false} ;
      A18MprCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmodalidadparcial__default(),
         new Object[] {
             new Object[] {
            P013E2_A18MprCod, P013E2_A1024MprEsParcial
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
   private boolean AV12MprEsParcial ;
   private boolean A1024MprEsParcial ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P013E2_A18MprCod ;
   private boolean[] P013E2_A1024MprEsParcial ;
}

final  class getmodalidadparcial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013E2", "SELECT MprCod, MprEsParcial FROM ModalidadAFIP WHERE MprCod = ( ?) ORDER BY MprCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

