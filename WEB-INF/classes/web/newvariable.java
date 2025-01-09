package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newvariable extends GXProcedure
{
   public newvariable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newvariable.class ), "" );
   }

   public newvariable( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        int aP8 ,
                        int aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             int aP8 ,
                             int aP9 )
   {
      newvariable.this.AV18CliCod = aP0;
      newvariable.this.AV17OpeCliId = aP1;
      newvariable.this.AV16OpeCliCodFormula = aP2;
      newvariable.this.AV15OpeCliDescrip = aP3;
      newvariable.this.AV11OpeCliUsuCre = aP4;
      newvariable.this.AV12OpeCliFecCre = aP5;
      newvariable.this.AV10OpeCliEsCant = aP6;
      newvariable.this.AV9OpeCliAliEs = aP7;
      newvariable.this.AV8VarRelSec = aP8;
      newvariable.this.AV19ValRelSecCli = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14OpeCliIdMay = GXutil.upper( GXutil.trim( AV16OpeCliCodFormula)) ;
      GXv_char1[0] = AV14OpeCliIdMay ;
      new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
      newvariable.this.AV14OpeCliIdMay = GXv_char1[0] ;
      AV14OpeCliIdMay = GXutil.strReplace( AV14OpeCliIdMay, " X", "") ;
      /*
         INSERT RECORD ON TABLE Variable

      */
      A3CliCod = AV18CliCod ;
      A82OpeCliId = AV17OpeCliId ;
      A549OpeCliCodFormula = AV16OpeCliCodFormula ;
      A534OpeCliDescrip = AV15OpeCliDescrip ;
      A536OpeCliIdMay = AV14OpeCliIdMay ;
      A544OpeCliUsuCre = AV11OpeCliUsuCre ;
      A545OpeCliFecCre = AV12OpeCliFecCre ;
      A931OpeCliEsCant = AV10OpeCliEsCant ;
      A934OpeCliAliEs = AV9OpeCliAliEs ;
      A1895VarRelSec = AV8VarRelSec ;
      A1903ValRelSecCli = AV19ValRelSecCli ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "le new ", "")+GXutil.trim( GXutil.str( AV8VarRelSec, 6, 0))) ;
      A2011VarRelRef = "" ;
      A2025VarOld = "" ;
      A2140VarDetail = "" ;
      /* Using cursor P01T82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A549OpeCliCodFormula, A534OpeCliDescrip, A536OpeCliIdMay, A544OpeCliUsuCre, A545OpeCliFecCre, Boolean.valueOf(A931OpeCliEsCant), Boolean.valueOf(A934OpeCliAliEs), Integer.valueOf(A1895VarRelSec), Integer.valueOf(A1903ValRelSecCli), A2011VarRelRef, A2025VarOld, A2140VarDetail});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newvariable");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14OpeCliIdMay = "" ;
      GXv_char1 = new String[1] ;
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      A534OpeCliDescrip = "" ;
      A536OpeCliIdMay = "" ;
      A544OpeCliUsuCre = "" ;
      A545OpeCliFecCre = GXutil.nullDate() ;
      AV22Pgmname = "" ;
      A2011VarRelRef = "" ;
      A2025VarOld = "" ;
      A2140VarDetail = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newvariable__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV22Pgmname = "newVariable" ;
      /* GeneXus formulas. */
      AV22Pgmname = "newVariable" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV8VarRelSec ;
   private int AV19ValRelSecCli ;
   private int GX_INS71 ;
   private int A3CliCod ;
   private int A1895VarRelSec ;
   private int A1903ValRelSecCli ;
   private String AV17OpeCliId ;
   private String AV16OpeCliCodFormula ;
   private String AV14OpeCliIdMay ;
   private String GXv_char1[] ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String A536OpeCliIdMay ;
   private String AV22Pgmname ;
   private String Gx_emsg ;
   private java.util.Date AV12OpeCliFecCre ;
   private java.util.Date A545OpeCliFecCre ;
   private boolean AV10OpeCliEsCant ;
   private boolean AV9OpeCliAliEs ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private String A2025VarOld ;
   private String AV15OpeCliDescrip ;
   private String AV11OpeCliUsuCre ;
   private String A534OpeCliDescrip ;
   private String A544OpeCliUsuCre ;
   private String A2011VarRelRef ;
   private String A2140VarDetail ;
   private IDataStoreProvider pr_default ;
}

final  class newvariable__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01T82", "SAVEPOINT gxupdate;INSERT INTO Variable(CliCod, OpeCliId, OpeCliCodFormula, OpeCliDescrip, OpeCliIdMay, OpeCliUsuCre, OpeCliFecCre, OpeCliEsCant, OpeCliAliEs, VarRelSec, ValRelSecCli, VarRelRef, VarOld, VarDetail, OpeCLiAliLey, VarBusGoogle, VarBusWeb, VarBaseURL, VarScrapTDoc, VarScrapTipo, VarFrecAct, OpeCliIdPadre, VarScrapFin, VarActObl, VarHelp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, '', '', '', '', '', 0, '', '', FALSE, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setVarchar(12, (String)parms[11], 40, false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               return;
      }
   }

}

