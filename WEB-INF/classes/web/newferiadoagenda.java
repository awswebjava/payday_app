package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newferiadoagenda extends GXProcedure
{
   public newferiadoagenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newferiadoagenda.class ), "" );
   }

   public newferiadoagenda( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        short aP2 ,
                        byte aP3 ,
                        short aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             short aP2 ,
                             byte aP3 ,
                             short aP4 )
   {
      newferiadoagenda.this.AV8PaiCod = aP0;
      newferiadoagenda.this.AV9FerId = aP1;
      newferiadoagenda.this.AV10FerAnio = aP2;
      newferiadoagenda.this.AV11mes = aP3;
      newferiadoagenda.this.AV12dia = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = GXutil.trim( AV9FerId) ;
      A1226FerAnio = AV10FerAnio ;
      A1227FerFecha = localUtil.ymdtod( AV10FerAnio, AV11mes, AV12dia) ;
      /* Using cursor P01YL2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newferiadoagenda");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1223FerId = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newferiadoagenda__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11mes ;
   private short AV8PaiCod ;
   private short AV10FerAnio ;
   private short AV12dia ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short Gx_err ;
   private int GX_INS243 ;
   private String AV9FerId ;
   private String A1223FerId ;
   private String Gx_emsg ;
   private java.util.Date A1227FerFecha ;
   private IDataStoreProvider pr_default ;
}

final  class newferiadoagenda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01YL2", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

