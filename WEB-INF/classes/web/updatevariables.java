package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatevariables extends GXProcedure
{
   public updatevariables( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatevariables.class ), "" );
   }

   public updatevariables( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updatevariables.this.AV11ClientePadre = aP0;
      updatevariables.this.AV10CliCod = aP1;
      updatevariables.this.AV13CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV25padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV11ClientePadre), AV13CliRelSec, GXv_dtime1) ;
      updatevariables.this.AV25padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&ClientePadre ", "")+GXutil.trim( GXutil.str( AV11ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV13CliRelSec, 6, 0))) ;
      AV33GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV13CliRelSec) ,
                                           Integer.valueOf(A1895VarRelSec) ,
                                           Long.valueOf(AV11ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RM2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV11ClientePadre), Integer.valueOf(AV13CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1895VarRelSec = P01RM2_A1895VarRelSec[0] ;
         A3CliCod = P01RM2_A3CliCod[0] ;
         A82OpeCliId = P01RM2_A82OpeCliId[0] ;
         A549OpeCliCodFormula = P01RM2_A549OpeCliCodFormula[0] ;
         A534OpeCliDescrip = P01RM2_A534OpeCliDescrip[0] ;
         A536OpeCliIdMay = P01RM2_A536OpeCliIdMay[0] ;
         A931OpeCliEsCant = P01RM2_A931OpeCliEsCant[0] ;
         A934OpeCliAliEs = P01RM2_A934OpeCliAliEs[0] ;
         AV33GXLvl4 = (byte)(1) ;
         AV17itemVariable = (web.Sdtsdt_variables_sdt_variablesItem)new web.Sdtsdt_variables_sdt_variablesItem(remoteHandle, context);
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid( A82OpeCliId );
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula( A549OpeCliCodFormula );
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip( A534OpeCliDescrip );
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay( A536OpeCliIdMay );
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant( A931OpeCliEsCant );
         AV17itemVariable.setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies( A934OpeCliAliEs );
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "add ", "")+A82OpeCliId) ;
         AV26sdt_variables.add(AV17itemVariable, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV33GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      if ( AV26sdt_variables.size() > 0 )
      {
         AV34GXLvl22 = (byte)(0) ;
         /* Using cursor P01RM3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RM3_A3CliCod[0] ;
            AV34GXLvl22 = (byte)(1) ;
            AV15hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "2") ;
            AV35GXV1 = 1 ;
            while ( AV35GXV1 <= AV26sdt_variables.size() )
            {
               AV17itemVariable = (web.Sdtsdt_variables_sdt_variablesItem)((web.Sdtsdt_variables_sdt_variablesItem)AV26sdt_variables.elementAt(-1+AV35GXV1));
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "3") ;
               AV21OpeCliId = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid() ;
               AV18OpeCliCodFormula = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula() ;
               AV19OpeCliDescrip = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip() ;
               AV9OpeCliIdMay = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay() ;
               AV20OpeCliEsCant = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant() ;
               AV8OpeCliAliEs = AV17itemVariable.getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies() ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV35GXV1 = (int)(AV35GXV1+1) ;
            }
            if ( AV13CliRelSec != 0 )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV34GXLvl22 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "none2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "4") ;
      AV36GXLvl48 = (byte)(0) ;
      /* Using cursor P01RM4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV15hijoCliCod), Long.valueOf(AV11ClientePadre), AV21OpeCliId});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1906OpeCliIdPadre = P01RM4_A1906OpeCliIdPadre[0] ;
         A1903ValRelSecCli = P01RM4_A1903ValRelSecCli[0] ;
         A3CliCod = P01RM4_A3CliCod[0] ;
         A1895VarRelSec = P01RM4_A1895VarRelSec[0] ;
         A534OpeCliDescrip = P01RM4_A534OpeCliDescrip[0] ;
         A536OpeCliIdMay = P01RM4_A536OpeCliIdMay[0] ;
         A549OpeCliCodFormula = P01RM4_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P01RM4_A82OpeCliId[0] ;
         AV36GXLvl48 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "5") ;
         if ( ! (0==AV13CliRelSec) )
         {
            GXv_dtime1[0] = AV16hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1895VarRelSec, GXv_dtime1) ;
            updatevariables.this.AV16hijoReleaseDateTime = GXv_dtime1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "6") ;
            if ( AV25padreReleaseDateTime.after( AV16hijoReleaseDateTime ) )
            {
               A534OpeCliDescrip = AV19OpeCliDescrip ;
               A1895VarRelSec = AV13CliRelSec ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "le update ", "")+GXutil.trim( GXutil.str( AV13CliRelSec, 6, 0))) ;
               A1903ValRelSecCli = (int)(AV11ClientePadre) ;
               AV9OpeCliIdMay = GXutil.upper( GXutil.trim( AV18OpeCliCodFormula)) ;
               GXv_char2[0] = AV9OpeCliIdMay ;
               new web.removercorchetes(remoteHandle, context).execute( GXv_char2) ;
               updatevariables.this.AV9OpeCliIdMay = GXv_char2[0] ;
               A536OpeCliIdMay = GXutil.strReplace( AV9OpeCliIdMay, " X", "") ;
               if ( ! (GXutil.strcmp("", A549OpeCliCodFormula)==0) && ( GXutil.strcmp(A549OpeCliCodFormula, AV18OpeCliCodFormula) != 0 ) )
               {
                  new web.formulapropagarconstante(remoteHandle, context).execute( AV10CliCod, (short)(1), A549OpeCliCodFormula, AV18OpeCliCodFormula) ;
               }
               A549OpeCliCodFormula = AV18OpeCliCodFormula ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "7") ;
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01RM5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1903ValRelSecCli), Integer.valueOf(A1895VarRelSec), A534OpeCliDescrip, A536OpeCliIdMay, A549OpeCliCodFormula, Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         if (true) break;
         /* Using cursor P01RM6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A1903ValRelSecCli), Integer.valueOf(A1895VarRelSec), A534OpeCliDescrip, A536OpeCliIdMay, A549OpeCliCodFormula, Integer.valueOf(A3CliCod), A82OpeCliId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV36GXLvl48 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "new", "")) ;
         /* Execute user subroutine: 'GET NUEVO ID' */
         S121 ();
         if (returnInSub) return;
         new web.newvariable(remoteHandle, context).execute( AV15hijoCliCod, AV28nuevoOpeCliId, AV18OpeCliCodFormula, AV19OpeCliDescrip, new web.getusulogged(remoteHandle, context).executeUdp( ), GXutil.serverDate( context, remoteHandle, pr_default), AV20OpeCliEsCant, AV8OpeCliAliEs, AV13CliRelSec, (int)(AV11ClientePadre)) ;
      }
   }

   public void S121( )
   {
      /* 'GET NUEVO ID' Routine */
      returnInSub = false ;
      AV27auxOpeCliId = AV21OpeCliId ;
      AV29i = (short)(1) ;
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV37GXLvl88 = (byte)(0) ;
         /* Using cursor P01RM7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(AV15hijoCliCod), AV27auxOpeCliId});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A82OpeCliId = P01RM7_A82OpeCliId[0] ;
            A3CliCod = P01RM7_A3CliCod[0] ;
            AV37GXLvl88 = (byte)(1) ;
            AV29i = (short)(AV29i+2) ;
            AV27auxOpeCliId = GXutil.trim( AV21OpeCliId) + "_" + GXutil.trim( GXutil.str( AV29i, 4, 0)) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(5);
         if ( AV37GXLvl88 == 0 )
         {
            AV28nuevoOpeCliId = AV27auxOpeCliId ;
         }
         if ( ! (GXutil.strcmp("", AV28nuevoOpeCliId)==0) )
         {
            if (true) break;
         }
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatevariables");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV32Pgmname = "" ;
      scmdbuf = "" ;
      P01RM2_A1895VarRelSec = new int[1] ;
      P01RM2_A3CliCod = new int[1] ;
      P01RM2_A82OpeCliId = new String[] {""} ;
      P01RM2_A549OpeCliCodFormula = new String[] {""} ;
      P01RM2_A534OpeCliDescrip = new String[] {""} ;
      P01RM2_A536OpeCliIdMay = new String[] {""} ;
      P01RM2_A931OpeCliEsCant = new boolean[] {false} ;
      P01RM2_A934OpeCliAliEs = new boolean[] {false} ;
      A82OpeCliId = "" ;
      A549OpeCliCodFormula = "" ;
      A534OpeCliDescrip = "" ;
      A536OpeCliIdMay = "" ;
      AV17itemVariable = new web.Sdtsdt_variables_sdt_variablesItem(remoteHandle, context);
      AV26sdt_variables = new GXBaseCollection<web.Sdtsdt_variables_sdt_variablesItem>(web.Sdtsdt_variables_sdt_variablesItem.class, "sdt_variablesItem", "PayDay", remoteHandle);
      P01RM3_A3CliCod = new int[1] ;
      AV21OpeCliId = "" ;
      AV18OpeCliCodFormula = "" ;
      AV19OpeCliDescrip = "" ;
      AV9OpeCliIdMay = "" ;
      P01RM4_A1906OpeCliIdPadre = new String[] {""} ;
      P01RM4_A1903ValRelSecCli = new int[1] ;
      P01RM4_A3CliCod = new int[1] ;
      P01RM4_A1895VarRelSec = new int[1] ;
      P01RM4_A534OpeCliDescrip = new String[] {""} ;
      P01RM4_A536OpeCliIdMay = new String[] {""} ;
      P01RM4_A549OpeCliCodFormula = new String[] {""} ;
      P01RM4_A82OpeCliId = new String[] {""} ;
      A1906OpeCliIdPadre = "" ;
      AV16hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      GXv_char2 = new String[1] ;
      AV28nuevoOpeCliId = "" ;
      AV27auxOpeCliId = "" ;
      P01RM7_A82OpeCliId = new String[] {""} ;
      P01RM7_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatevariables__default(),
         new Object[] {
             new Object[] {
            P01RM2_A1895VarRelSec, P01RM2_A3CliCod, P01RM2_A82OpeCliId, P01RM2_A549OpeCliCodFormula, P01RM2_A534OpeCliDescrip, P01RM2_A536OpeCliIdMay, P01RM2_A931OpeCliEsCant, P01RM2_A934OpeCliAliEs
            }
            , new Object[] {
            P01RM3_A3CliCod
            }
            , new Object[] {
            P01RM4_A1906OpeCliIdPadre, P01RM4_A1903ValRelSecCli, P01RM4_A3CliCod, P01RM4_A1895VarRelSec, P01RM4_A534OpeCliDescrip, P01RM4_A536OpeCliIdMay, P01RM4_A549OpeCliCodFormula, P01RM4_A82OpeCliId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01RM7_A82OpeCliId, P01RM7_A3CliCod
            }
         }
      );
      AV32Pgmname = "updateVariables" ;
      /* GeneXus formulas. */
      AV32Pgmname = "updateVariables" ;
      Gx_err = (short)(0) ;
   }

   private byte AV33GXLvl4 ;
   private byte AV34GXLvl22 ;
   private byte AV36GXLvl48 ;
   private byte AV37GXLvl88 ;
   private short AV29i ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13CliRelSec ;
   private int A1895VarRelSec ;
   private int A3CliCod ;
   private int AV15hijoCliCod ;
   private int AV35GXV1 ;
   private int A1903ValRelSecCli ;
   private long AV11ClientePadre ;
   private String AV32Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String A536OpeCliIdMay ;
   private String AV21OpeCliId ;
   private String AV18OpeCliCodFormula ;
   private String AV9OpeCliIdMay ;
   private String A1906OpeCliIdPadre ;
   private String GXv_char2[] ;
   private String AV28nuevoOpeCliId ;
   private String AV27auxOpeCliId ;
   private java.util.Date AV25padreReleaseDateTime ;
   private java.util.Date AV16hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean AV20OpeCliEsCant ;
   private boolean AV8OpeCliAliEs ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String A534OpeCliDescrip ;
   private String AV19OpeCliDescrip ;
   private IDataStoreProvider pr_default ;
   private int[] P01RM2_A1895VarRelSec ;
   private int[] P01RM2_A3CliCod ;
   private String[] P01RM2_A82OpeCliId ;
   private String[] P01RM2_A549OpeCliCodFormula ;
   private String[] P01RM2_A534OpeCliDescrip ;
   private String[] P01RM2_A536OpeCliIdMay ;
   private boolean[] P01RM2_A931OpeCliEsCant ;
   private boolean[] P01RM2_A934OpeCliAliEs ;
   private int[] P01RM3_A3CliCod ;
   private String[] P01RM4_A1906OpeCliIdPadre ;
   private int[] P01RM4_A1903ValRelSecCli ;
   private int[] P01RM4_A3CliCod ;
   private int[] P01RM4_A1895VarRelSec ;
   private String[] P01RM4_A534OpeCliDescrip ;
   private String[] P01RM4_A536OpeCliIdMay ;
   private String[] P01RM4_A549OpeCliCodFormula ;
   private String[] P01RM4_A82OpeCliId ;
   private String[] P01RM7_A82OpeCliId ;
   private int[] P01RM7_A3CliCod ;
   private GXBaseCollection<web.Sdtsdt_variables_sdt_variablesItem> AV26sdt_variables ;
   private web.Sdtsdt_variables_sdt_variablesItem AV17itemVariable ;
}

final  class updatevariables__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV13CliRelSec ,
                                          int A1895VarRelSec ,
                                          long AV11ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT VarRelSec, CliCod, OpeCliId, OpeCliCodFormula, OpeCliDescrip, OpeCliIdMay, OpeCliEsCant, OpeCliAliEs FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV13CliRelSec) )
      {
         addWhere(sWhereString, "(VarRelSec = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
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
                  return conditional_P01RM2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RM3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RM4", "SELECT OpeCliIdPadre, ValRelSecCli, CliCod, VarRelSec, OpeCliDescrip, OpeCliIdMay, OpeCliCodFormula, OpeCliId FROM Variable WHERE (CliCod = ?) AND (ValRelSecCli = ?) AND (OpeCliIdPadre = ( ?)) ORDER BY CliCod  LIMIT 1 FOR UPDATE OF Variable",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RM5", "SAVEPOINT gxupdate;UPDATE Variable SET ValRelSecCli=?, VarRelSec=?, OpeCliDescrip=?, OpeCliIdMay=?, OpeCliCodFormula=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01RM6", "SAVEPOINT gxupdate;UPDATE Variable SET ValRelSecCli=?, VarRelSec=?, OpeCliDescrip=?, OpeCliIdMay=?, OpeCliCodFormula=?  WHERE CliCod = ? AND OpeCliId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01RM7", "SELECT OpeCliId, CliCod FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 40);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 40);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

