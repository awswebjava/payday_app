package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class addsubtipo extends GXProcedure
{
   public addsubtipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( addsubtipo.class ), "" );
   }

   public addsubtipo( int remoteHandle ,
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
      addsubtipo.this.AV10SubTipoConCod2 = aP0;
      addsubtipo.this.AV11SubTipoConDes2 = aP1;
      addsubtipo.this.AV9TipoConCod = aP2;
      addsubtipo.this.AV8SubTipoConCod1 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE tipo_concepto_subtipo2

      */
      A37TipoConCod = AV9TipoConCod ;
      A38SubTipoConCod1 = AV8SubTipoConCod1 ;
      A39SubTipoConCod2 = AV10SubTipoConCod2 ;
      A372SubTipoConDes2 = AV11SubTipoConDes2 ;
      /* Using cursor P001P2 */
      pr_default.execute(0, new Object[] {A37TipoConCod, A38SubTipoConCod1, A39SubTipoConCod2, A372SubTipoConDes2});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_concepto_subtipo2");
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
      if ( GXutil.strSearch( AV10SubTipoConCod2, "_", 1) == 0 )
      {
         /*
            INSERT RECORD ON TABLE AFIPConcepto

         */
         A72AFIPConCod = AV10SubTipoConCod2 ;
         A369AFIPConDescrip = AV11SubTipoConDes2 ;
         A387AfipConTipoConCod = AV9TipoConCod ;
         A388AfipConSubTipoConCod1 = AV8SubTipoConCod1 ;
         A385AfipConCodMasDesc = GXutil.trim( AV10SubTipoConCod2) + " - " + GXutil.trim( AV11SubTipoConDes2) ;
         if ( GXutil.strcmp(GXutil.trim( A72AFIPConCod), "150000") == 0 )
         {
            A1646AFIPConLiqAgil = false ;
         }
         else
         {
            A1646AFIPConLiqAgil = true ;
         }
         /* Using cursor P001P3 */
         pr_default.execute(1, new Object[] {A72AFIPConCod, A369AFIPConDescrip, A387AfipConTipoConCod, A388AfipConSubTipoConCod1, A385AfipConCodMasDesc, Boolean.valueOf(A1646AFIPConLiqAgil)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("AFIPConcepto");
         if ( (pr_default.getStatus(1) == 1) )
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "addsubtipo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      Gx_emsg = "" ;
      A72AFIPConCod = "" ;
      A369AFIPConDescrip = "" ;
      A387AfipConTipoConCod = "" ;
      A388AfipConSubTipoConCod1 = "" ;
      A385AfipConCodMasDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.addsubtipo__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS61 ;
   private int GX_INS58 ;
   private String AV10SubTipoConCod2 ;
   private String AV9TipoConCod ;
   private String AV8SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String Gx_emsg ;
   private String A72AFIPConCod ;
   private String A387AfipConTipoConCod ;
   private String A388AfipConSubTipoConCod1 ;
   private boolean A1646AFIPConLiqAgil ;
   private String AV11SubTipoConDes2 ;
   private String A372SubTipoConDes2 ;
   private String A369AFIPConDescrip ;
   private String A385AfipConCodMasDesc ;
   private IDataStoreProvider pr_default ;
}

final  class addsubtipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P001P2", "SAVEPOINT gxupdate;INSERT INTO tipo_concepto_subtipo2(TipoConCod, SubTipoConCod1, SubTipoConCod2, SubTipoConDes2) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001P3", "SAVEPOINT gxupdate;INSERT INTO AFIPConcepto(AFIPConCod, AFIPConDescrip, AfipConTipoConCod, AfipConSubTipoConCod1, AfipConCodMasDesc, AFIPConLiqAgil) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               return;
            case 1 :
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

