package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconceptotipoliq extends GXProcedure
{
   public newconceptotipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconceptotipoliq.class ), "" );
   }

   public newconceptotipoliq( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      newconceptotipoliq.this.AV10CliCod = aP0;
      newconceptotipoliq.this.AV9ConCodigo = aP1;
      newconceptotipoliq.this.AV8TLiqCod = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ConceptoTipoLiquidacion

      */
      A3CliCod = AV10CliCod ;
      A26ConCodigo = AV9ConCodigo ;
      A32TLiqCod = AV8TLiqCod ;
      /* Using cursor P01NH2 */
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconceptotipoliq");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconceptotipoliq__default(),
         new Object[] {
             new Object[] {
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
   private String AV8TLiqCod ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private String Gx_emsg ;
   private IDataStoreProvider pr_default ;
}

final  class newconceptotipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01NH2", "SAVEPOINT gxupdate;INSERT INTO ConceptoTipoLiquidacion(CliCod, ConCodigo, TLiqCod, ConTLiqSinCausa, ConTLiqSinPre, ConTLTipEgr, ConTLOrdejec, ConTLConOrd, ConTLVigencia, ConTLCondicion, ConTLConHab, ConTLTipoCon, CONTLSegPla) VALUES(?, ?, ?, FALSE, FALSE, '', 0, 0, 0, '', 0, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

