package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class testgrabatipoliqs extends GXProcedure
{
   public testgrabatipoliqs( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( testgrabatipoliqs.class ), "" );
   }

   public testgrabatipoliqs( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      testgrabatipoliqs.this.AV10CliCod = aP0;
      testgrabatipoliqs.this.AV9ConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8mensualTLiqCod ;
      GXt_char2 = AV8mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      testgrabatipoliqs.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      testgrabatipoliqs.this.GXt_char1 = GXv_char4[0] ;
      AV8mensualTLiqCod = GXt_char1 ;
      GXt_char2 = AV11variosTLiqCod ;
      GXt_char1 = AV11variosTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      testgrabatipoliqs.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      testgrabatipoliqs.this.GXt_char2 = GXv_char3[0] ;
      AV11variosTLiqCod = GXt_char2 ;
      /*
         INSERT RECORD ON TABLE ConceptoTipoLiquidacion

      */
      A3CliCod = AV10CliCod ;
      A26ConCodigo = AV9ConCodigo ;
      A32TLiqCod = AV8mensualTLiqCod ;
      /* Using cursor P01KG2 */
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
      /*
         INSERT RECORD ON TABLE ConceptoTipoLiquidacion

      */
      A3CliCod = AV10CliCod ;
      A26ConCodigo = AV9ConCodigo ;
      A32TLiqCod = AV11variosTLiqCod ;
      /* Using cursor P01KG3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A32TLiqCod});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoTipoLiquidacion");
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
      new web.ajustartiposliq(remoteHandle, context).execute( AV10CliCod, (short)(0), AV9ConCodigo, "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "testgrabatipoliqs");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8mensualTLiqCod = "" ;
      AV11variosTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.testgrabatipoliqs__default(),
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
   private int AV10CliCod ;
   private int GX_INS8 ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV8mensualTLiqCod ;
   private String AV11variosTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private String Gx_emsg ;
   private IDataStoreProvider pr_default ;
}

final  class testgrabatipoliqs__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01KG2", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01KG3", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

