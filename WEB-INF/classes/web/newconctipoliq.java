package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconctipoliq extends GXProcedure
{
   public newconctipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconctipoliq.class ), "" );
   }

   public newconctipoliq( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 )
   {
      newconctipoliq.this.AV9CliCod = aP0;
      newconctipoliq.this.AV11ConCodigo = aP1;
      newconctipoliq.this.AV8SubTipoConCod1 = aP2;
      newconctipoliq.this.AV12exclusivoMensualEs = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV12exclusivoMensualEs )
      {
         GXt_char1 = AV10mensualTLiqCod ;
         GXt_char2 = AV10mensualTLiqCod ;
         GXv_char3[0] = GXt_char2 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         newconctipoliq.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
         newconctipoliq.this.GXt_char1 = GXv_char4[0] ;
         AV10mensualTLiqCod = GXt_char1 ;
         /*
            INSERT RECORD ON TABLE ConceptoTipoLiquidacion

         */
         A3CliCod = AV9CliCod ;
         A26ConCodigo = AV11ConCodigo ;
         A32TLiqCod = AV10mensualTLiqCod ;
         /* Using cursor P00TN2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconctipoliq");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconctipoliq__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int GX_INS8 ;
   private int A3CliCod ;
   private String AV11ConCodigo ;
   private String AV8SubTipoConCod1 ;
   private String AV10mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private String Gx_emsg ;
   private boolean AV12exclusivoMensualEs ;
   private IDataStoreProvider pr_default ;
}

final  class newconctipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00TN2", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

