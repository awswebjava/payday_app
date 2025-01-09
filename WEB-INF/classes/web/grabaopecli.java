package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaopecli extends GXProcedure
{
   public grabaopecli( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaopecli.class ), "" );
   }

   public grabaopecli( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        java.util.Date aP8 ,
                        boolean aP9 ,
                        int aP10 ,
                        int aP11 ,
                        int aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             boolean aP9 ,
                             int aP10 ,
                             int aP11 ,
                             int aP12 )
   {
      grabaopecli.this.AV10CliCod = aP0;
      grabaopecli.this.AV15parmOpeCliId = aP1;
      grabaopecli.this.AV16oldOpeCliCodFormula = aP2;
      grabaopecli.this.AV14OpeCliCodFormula = aP3;
      grabaopecli.this.AV11OpeCliDescrip = aP4;
      grabaopecli.this.AV9OpeCliValor = aP5;
      grabaopecli.this.AV13variable = aP6;
      grabaopecli.this.AV18OpeCliVig = aP7;
      grabaopecli.this.AV22OpeCliVRetro = aP8;
      grabaopecli.this.AV21minusculas = aP9;
      grabaopecli.this.AV25VarRelSec = aP10;
      grabaopecli.this.AV24OpeCliRelSec = aP11;
      grabaopecli.this.AV26OpeCliRelSecCli = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&OpeCliCodFormula ", "")+GXutil.trim( AV14OpeCliCodFormula)) ;
      AV30GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV15parmOpeCliId ,
                                           A82OpeCliId ,
                                           A549OpeCliCodFormula ,
                                           AV14OpeCliCodFormula ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00JP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV15parmOpeCliId, AV14OpeCliCodFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A549OpeCliCodFormula = P00JP2_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P00JP2_A82OpeCliId[0] ;
         A3CliCod = P00JP2_A3CliCod[0] ;
         A536OpeCliIdMay = P00JP2_A536OpeCliIdMay[0] ;
         A534OpeCliDescrip = P00JP2_A534OpeCliDescrip[0] ;
         A1895VarRelSec = P00JP2_A1895VarRelSec[0] ;
         AV30GXLvl2 = (byte)(1) ;
         A534OpeCliDescrip = AV11OpeCliDescrip ;
         A549OpeCliCodFormula = AV14OpeCliCodFormula ;
         A1895VarRelSec = AV25VarRelSec ;
         AV8OpeCliId = A82OpeCliId ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "le update ", "")+GXutil.trim( GXutil.str( AV25VarRelSec, 6, 0))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00JP3 */
         pr_default.execute(1, new Object[] {A549OpeCliCodFormula, A534OpeCliDescrip, Integer.valueOf(A1895VarRelSec), Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         if (true) break;
         /* Using cursor P00JP4 */
         pr_default.execute(2, new Object[] {A549OpeCliCodFormula, A534OpeCliDescrip, Integer.valueOf(A1895VarRelSec), Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV30GXLvl2 == 0 )
      {
         AV12OpeCliIdMay = GXutil.upper( GXutil.trim( AV14OpeCliCodFormula)) ;
         GXv_char1[0] = AV12OpeCliIdMay ;
         new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
         grabaopecli.this.AV12OpeCliIdMay = GXv_char1[0] ;
         AV12OpeCliIdMay = GXutil.strReplace( AV12OpeCliIdMay, " X", "") ;
         new web.msgdebug7(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "(&OpeCliIdMay ", "")+AV12OpeCliIdMay) ;
         if ( ! (GXutil.strcmp("", AV15parmOpeCliId)==0) )
         {
            AV8OpeCliId = AV15parmOpeCliId ;
         }
         else
         {
            GXv_char1[0] = AV8OpeCliId ;
            new web.newcodigoopecliid(remoteHandle, context).execute( AV10CliCod, GXutil.lower( AV12OpeCliIdMay), GXv_char1) ;
            grabaopecli.this.AV8OpeCliId = GXv_char1[0] ;
         }
         /*
            INSERT RECORD ON TABLE Variable

         */
         A3CliCod = AV10CliCod ;
         A82OpeCliId = AV8OpeCliId ;
         A1895VarRelSec = AV25VarRelSec ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "le new ", "")+GXutil.trim( GXutil.str( AV25VarRelSec, 6, 0))) ;
         AV20OpeCliCodFormulaAux = AV14OpeCliCodFormula ;
         if ( GXutil.strcmp(AV8OpeCliId, "[gan_escala]") == 0 )
         {
            AV20OpeCliCodFormulaAux = GXutil.strReplace( AV20OpeCliCodFormulaAux, "[", "{") ;
            AV20OpeCliCodFormulaAux = GXutil.strReplace( AV20OpeCliCodFormulaAux, "]", "}") ;
         }
         if ( AV21minusculas )
         {
            A549OpeCliCodFormula = GXutil.lower( AV20OpeCliCodFormulaAux) ;
         }
         else
         {
            A549OpeCliCodFormula = AV20OpeCliCodFormulaAux ;
         }
         A534OpeCliDescrip = AV11OpeCliDescrip ;
         A536OpeCliIdMay = AV12OpeCliIdMay ;
         GXt_char2 = A544OpeCliUsuCre ;
         GXv_char1[0] = GXt_char2 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char1) ;
         grabaopecli.this.GXt_char2 = GXv_char1[0] ;
         A544OpeCliUsuCre = GXt_char2 ;
         A545OpeCliFecCre = GXutil.serverDate( context, remoteHandle, pr_default) ;
         if ( ( GXutil.strcmp(AV8OpeCliId, "[apo_jub_ali]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[apo_OS_ali]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[apo_INSSJyP_ali]") == 0 ) )
         {
            A741OpeCLiAliLey = true ;
         }
         else
         {
            A741OpeCLiAliLey = false ;
         }
         A2011VarRelRef = "" ;
         A2025VarOld = "" ;
         A2140VarDetail = "" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "fin graba ", "")) ;
         /* Using cursor P00JP5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A549OpeCliCodFormula, A534OpeCliDescrip, A536OpeCliIdMay, A544OpeCliUsuCre, A545OpeCliFecCre, Boolean.valueOf(A741OpeCLiAliLey), Integer.valueOf(A1895VarRelSec), A2011VarRelRef, A2025VarOld, A2140VarDetail});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         if ( (pr_default.getStatus(3) == 1) )
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
      if ( ! (GXutil.strcmp("", AV9OpeCliValor)==0) )
      {
         if ( (GXutil.strcmp("", AV8OpeCliId)==0) )
         {
            AV8OpeCliId = AV15parmOpeCliId ;
         }
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18OpeCliVig)) )
         {
            AV19auxOpeCliVig = GXutil.serverDate( context, remoteHandle, pr_default) ;
            AV23actualizarRetroactiva = false ;
         }
         else
         {
            AV19auxOpeCliVig = AV18OpeCliVig ;
            AV23actualizarRetroactiva = true ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "ini graba valor ", "")) ;
         new web.grabaopeclivalor(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV19auxOpeCliVig, AV22OpeCliVRetro, AV23actualizarRetroactiva, AV9OpeCliValor, AV24OpeCliRelSec, AV26OpeCliRelSecCli) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "fin graba valor ", "")) ;
      }
      if ( ! (GXutil.strcmp("", AV16oldOpeCliCodFormula)==0) && ( GXutil.strcmp(AV16oldOpeCliCodFormula, AV14OpeCliCodFormula) != 0 ) )
      {
         new web.formulapropagarconstante(remoteHandle, context).execute( AV10CliCod, (short)(1), AV16oldOpeCliCodFormula, AV14OpeCliCodFormula) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaopecli");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29Pgmname = "" ;
      scmdbuf = "" ;
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      P00JP2_A549OpeCliCodFormula = new String[] {""} ;
      P00JP2_A82OpeCliId = new String[] {""} ;
      P00JP2_A3CliCod = new int[1] ;
      P00JP2_A536OpeCliIdMay = new String[] {""} ;
      P00JP2_A534OpeCliDescrip = new String[] {""} ;
      P00JP2_A1895VarRelSec = new int[1] ;
      A536OpeCliIdMay = "" ;
      A534OpeCliDescrip = "" ;
      AV8OpeCliId = "" ;
      AV12OpeCliIdMay = "" ;
      AV20OpeCliCodFormulaAux = "" ;
      A544OpeCliUsuCre = "" ;
      GXt_char2 = "" ;
      GXv_char1 = new String[1] ;
      A545OpeCliFecCre = GXutil.nullDate() ;
      A2011VarRelRef = "" ;
      A2025VarOld = "" ;
      A2140VarDetail = "" ;
      Gx_emsg = "" ;
      AV19auxOpeCliVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaopecli__default(),
         new Object[] {
             new Object[] {
            P00JP2_A549OpeCliCodFormula, P00JP2_A82OpeCliId, P00JP2_A3CliCod, P00JP2_A536OpeCliIdMay, P00JP2_A534OpeCliDescrip, P00JP2_A1895VarRelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV29Pgmname = "GrabaOpeCli" ;
      /* GeneXus formulas. */
      AV29Pgmname = "GrabaOpeCli" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30GXLvl2 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV25VarRelSec ;
   private int AV24OpeCliRelSec ;
   private int AV26OpeCliRelSecCli ;
   private int A3CliCod ;
   private int A1895VarRelSec ;
   private int GX_INS71 ;
   private String AV15parmOpeCliId ;
   private String AV16oldOpeCliCodFormula ;
   private String AV14OpeCliCodFormula ;
   private String AV13variable ;
   private String AV29Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String A536OpeCliIdMay ;
   private String AV8OpeCliId ;
   private String AV12OpeCliIdMay ;
   private String AV20OpeCliCodFormulaAux ;
   private String GXt_char2 ;
   private String GXv_char1[] ;
   private String Gx_emsg ;
   private java.util.Date AV18OpeCliVig ;
   private java.util.Date AV22OpeCliVRetro ;
   private java.util.Date A545OpeCliFecCre ;
   private java.util.Date AV19auxOpeCliVig ;
   private boolean AV21minusculas ;
   private boolean A741OpeCLiAliLey ;
   private boolean AV23actualizarRetroactiva ;
   private String AV9OpeCliValor ;
   private String A2025VarOld ;
   private String AV11OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private String A544OpeCliUsuCre ;
   private String A2011VarRelRef ;
   private String A2140VarDetail ;
   private IDataStoreProvider pr_default ;
   private String[] P00JP2_A549OpeCliCodFormula ;
   private String[] P00JP2_A82OpeCliId ;
   private int[] P00JP2_A3CliCod ;
   private String[] P00JP2_A536OpeCliIdMay ;
   private String[] P00JP2_A534OpeCliDescrip ;
   private int[] P00JP2_A1895VarRelSec ;
}

final  class grabaopecli__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00JP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15parmOpeCliId ,
                                          String A82OpeCliId ,
                                          String A549OpeCliCodFormula ,
                                          String AV14OpeCliCodFormula ,
                                          int AV10CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT OpeCliCodFormula, OpeCliId, CliCod, OpeCliIdMay, OpeCliDescrip, VarRelSec FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV15parmOpeCliId)==0) )
      {
         addWhere(sWhereString, "(OpeCliId = ( ?))");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV15parmOpeCliId)==0) )
      {
         addWhere(sWhereString, "(OpeCliCodFormula = ( ?))");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      scmdbuf += " FOR UPDATE OF Variable" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00JP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JP2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00JP3", "SAVEPOINT gxupdate;UPDATE Variable SET OpeCliCodFormula=?, OpeCliDescrip=?, VarRelSec=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00JP4", "SAVEPOINT gxupdate;UPDATE Variable SET OpeCliCodFormula=?, OpeCliDescrip=?, VarRelSec=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00JP5", "SAVEPOINT gxupdate;INSERT INTO Variable(CliCod, OpeCliId, OpeCliCodFormula, OpeCliDescrip, OpeCliIdMay, OpeCliUsuCre, OpeCliFecCre, OpeCLiAliLey, VarRelSec, VarRelRef, VarOld, VarDetail, OpeCliEsCant, OpeCliAliEs, VarBusGoogle, VarBusWeb, VarBaseURL, VarScrapTDoc, VarScrapTipo, VarFrecAct, ValRelSecCli, OpeCliIdPadre, VarScrapFin, VarActObl, VarHelp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE, '', '', '', '', '', 0, 0, '', '', FALSE, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 40);
               }
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 40);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               return;
      }
   }

}

