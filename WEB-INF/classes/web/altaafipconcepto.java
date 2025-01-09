package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class altaafipconcepto extends GXProcedure
{
   public altaafipconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( altaafipconcepto.class ), "" );
   }

   public altaafipconcepto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      altaafipconcepto.this.AV9AFIPConCod = aP0;
      altaafipconcepto.this.AV12AFIPConDescrip = aP1;
      altaafipconcepto.this.AV11TipoConCod = aP2;
      altaafipconcepto.this.AV10SubTipoConCod1 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE AFIPConcepto

      */
      A72AFIPConCod = AV9AFIPConCod ;
      A369AFIPConDescrip = AV12AFIPConDescrip ;
      A387AfipConTipoConCod = AV11TipoConCod ;
      A388AfipConSubTipoConCod1 = AV10SubTipoConCod1 ;
      A385AfipConCodMasDesc = GXutil.trim( AV9AFIPConCod) + " - " + GXutil.trim( AV12AFIPConDescrip) ;
      if ( GXutil.strcmp(GXutil.trim( A72AFIPConCod), "150000") == 0 )
      {
         A1646AFIPConLiqAgil = false ;
      }
      else
      {
         A1646AFIPConLiqAgil = true ;
      }
      /* Using cursor P00FA2 */
      pr_default.execute(0, new Object[] {A72AFIPConCod, A369AFIPConDescrip, A387AfipConTipoConCod, A388AfipConSubTipoConCod1, A385AfipConCodMasDesc, Boolean.valueOf(A1646AFIPConLiqAgil)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("AFIPConcepto");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "altaafipconcepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A72AFIPConCod = "" ;
      A369AFIPConDescrip = "" ;
      A387AfipConTipoConCod = "" ;
      A388AfipConSubTipoConCod1 = "" ;
      A385AfipConCodMasDesc = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.altaafipconcepto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS58 ;
   private String AV9AFIPConCod ;
   private String AV11TipoConCod ;
   private String AV10SubTipoConCod1 ;
   private String A72AFIPConCod ;
   private String A387AfipConTipoConCod ;
   private String A388AfipConSubTipoConCod1 ;
   private String Gx_emsg ;
   private boolean A1646AFIPConLiqAgil ;
   private String AV12AFIPConDescrip ;
   private String A369AFIPConDescrip ;
   private String A385AfipConCodMasDesc ;
   private IDataStoreProvider pr_default ;
}

final  class altaafipconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00FA2", "SAVEPOINT gxupdate;INSERT INTO AFIPConcepto(AFIPConCod, AFIPConDescrip, AfipConTipoConCod, AfipConSubTipoConCod1, AfipConCodMasDesc, AFIPConLiqAgil) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 6);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 200, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
      }
   }

}

