package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updatevariablevalores extends GXProcedure
{
   public updatevariablevalores( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updatevariablevalores.class ), "" );
   }

   public updatevariablevalores( int remoteHandle ,
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
      updatevariablevalores.this.AV9ClientePadre = aP0;
      updatevariablevalores.this.AV8CliCod = aP1;
      updatevariablevalores.this.AV11CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV21padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV9ClientePadre), AV11CliRelSec, GXv_dtime1) ;
      updatevariablevalores.this.AV21padreReleaseDateTime = GXv_dtime1[0] ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV11CliRelSec) ,
                                           Integer.valueOf(A1890OpeCliRelSec) ,
                                           Long.valueOf(AV9ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RN2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV9ClientePadre), Integer.valueOf(AV11CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1890OpeCliRelSec = P01RN2_A1890OpeCliRelSec[0] ;
         A3CliCod = P01RN2_A3CliCod[0] ;
         A82OpeCliId = P01RN2_A82OpeCliId[0] ;
         A535OpeCliValor = P01RN2_A535OpeCliValor[0] ;
         A754OpeCliVig = P01RN2_A754OpeCliVig[0] ;
         A1146OpeCliVRetro = P01RN2_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = P01RN2_n1146OpeCliVRetro[0] ;
         AV14itemVariable = (web.Sdtsdt_variableValores_sdt_variableValoresItem)new web.Sdtsdt_variableValores_sdt_variableValoresItem(remoteHandle, context);
         AV14itemVariable.setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid( A82OpeCliId );
         AV14itemVariable.setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor( A535OpeCliValor );
         AV14itemVariable.setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig( A754OpeCliVig );
         AV14itemVariable.setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro( A1146OpeCliVRetro );
         AV14itemVariable.setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor( A535OpeCliValor );
         AV22sdt_variable.add(AV14itemVariable, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV22sdt_variable.size() > 0 )
      {
         /* Using cursor P01RN3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RN3_A3CliCod[0] ;
            AV12hijoCliCod = A3CliCod ;
            AV33GXV1 = 1 ;
            while ( AV33GXV1 <= AV22sdt_variable.size() )
            {
               AV14itemVariable = (web.Sdtsdt_variableValores_sdt_variableValoresItem)((web.Sdtsdt_variableValores_sdt_variableValoresItem)AV22sdt_variable.elementAt(-1+AV33GXV1));
               AV17OpeCliId = AV14itemVariable.getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid() ;
               AV19OpeCliVig = AV14itemVariable.getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig() ;
               AV20OpeCliVRetro = AV14itemVariable.getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro() ;
               AV18OpeCliValor = AV14itemVariable.getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor() ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV33GXV1 = (int)(AV33GXV1+1) ;
            }
            if ( AV11CliRelSec != 0 )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'BUSCAR ID PADRE' */
      S121 ();
      if (returnInSub) return;
      AV26actualizadoOpeCliId = "" ;
      AV27actualizadoOpeCliVig = GXutil.nullDate() ;
      AV34GXLvl42 = (byte)(0) ;
      /* Using cursor P01RN4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV12hijoCliCod), AV23auxOpeCliId, AV19OpeCliVig, Long.valueOf(AV9ClientePadre)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A754OpeCliVig = P01RN4_A754OpeCliVig[0] ;
         A82OpeCliId = P01RN4_A82OpeCliId[0] ;
         A1904OpeCliRelSecCli = P01RN4_A1904OpeCliRelSecCli[0] ;
         A3CliCod = P01RN4_A3CliCod[0] ;
         A1890OpeCliRelSec = P01RN4_A1890OpeCliRelSec[0] ;
         A535OpeCliValor = P01RN4_A535OpeCliValor[0] ;
         A1146OpeCliVRetro = P01RN4_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = P01RN4_n1146OpeCliVRetro[0] ;
         AV34GXLvl42 = (byte)(1) ;
         if ( ! (0==AV11CliRelSec) )
         {
            GXv_dtime1[0] = AV13hijoReleaseDateTime ;
            new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1890OpeCliRelSec, GXv_dtime1) ;
            updatevariablevalores.this.AV13hijoReleaseDateTime = GXv_dtime1[0] ;
            if ( AV21padreReleaseDateTime.after( AV13hijoReleaseDateTime ) )
            {
               AV26actualizadoOpeCliId = A82OpeCliId ;
               AV27actualizadoOpeCliVig = A754OpeCliVig ;
               A535OpeCliValor = AV18OpeCliValor ;
               A1890OpeCliRelSec = AV11CliRelSec ;
               A1904OpeCliRelSecCli = (int)(AV9ClientePadre) ;
               if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV20OpeCliVRetro)) )
               {
                  A1146OpeCliVRetro = GXutil.nullDate() ;
                  n1146OpeCliVRetro = false ;
                  n1146OpeCliVRetro = true ;
               }
               else
               {
                  A1146OpeCliVRetro = AV20OpeCliVRetro ;
                  n1146OpeCliVRetro = false ;
               }
            }
         }
         /* Using cursor P01RN5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A1904OpeCliRelSecCli), Integer.valueOf(A1890OpeCliRelSec), A535OpeCliValor, Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV34GXLvl42 == 0 )
      {
         new web.grabaopeclivalor(remoteHandle, context).execute( AV12hijoCliCod, AV17OpeCliId, AV19OpeCliVig, AV20OpeCliVRetro, true, AV18OpeCliValor, AV11CliRelSec, (int)(AV9ClientePadre)) ;
         AV26actualizadoOpeCliId = AV17OpeCliId ;
         AV27actualizadoOpeCliVig = AV19OpeCliVig ;
      }
      AV24maximoImponibleOpeCliId = "[base_imp_max]" ;
      AV25minimoImponibleOpeCliId = "[base_imp_min]" ;
      if ( ( GXutil.strcmp(AV26actualizadoOpeCliId, AV24maximoImponibleOpeCliId) == 0 ) || ( GXutil.strcmp(AV26actualizadoOpeCliId, AV25minimoImponibleOpeCliId) == 0 ) )
      {
         GXv_date2[0] = AV28proximaFecha ;
         new web.getproximafechavariable(remoteHandle, context).execute( AV12hijoCliCod, AV17OpeCliId, AV27actualizadoOpeCliVig, GXv_date2) ;
         updatevariablevalores.this.AV28proximaFecha = GXv_date2[0] ;
         new web.inicializarsueldoconceptos(remoteHandle, context).execute( AV12hijoCliCod, AV27actualizadoOpeCliVig, AV28proximaFecha) ;
      }
   }

   public void S121( )
   {
      /* 'BUSCAR ID PADRE' Routine */
      returnInSub = false ;
      /* Using cursor P01RN6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV12hijoCliCod), Long.valueOf(AV9ClientePadre), AV17OpeCliId});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A1906OpeCliIdPadre = P01RN6_A1906OpeCliIdPadre[0] ;
         A1903ValRelSecCli = P01RN6_A1903ValRelSecCli[0] ;
         A3CliCod = P01RN6_A3CliCod[0] ;
         A82OpeCliId = P01RN6_A82OpeCliId[0] ;
         AV23auxOpeCliId = A82OpeCliId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updatevariablevalores");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P01RN2_A1890OpeCliRelSec = new int[1] ;
      P01RN2_A3CliCod = new int[1] ;
      P01RN2_A82OpeCliId = new String[] {""} ;
      P01RN2_A535OpeCliValor = new String[] {""} ;
      P01RN2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RN2_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P01RN2_n1146OpeCliVRetro = new boolean[] {false} ;
      A82OpeCliId = "" ;
      A535OpeCliValor = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      AV14itemVariable = new web.Sdtsdt_variableValores_sdt_variableValoresItem(remoteHandle, context);
      AV22sdt_variable = new GXBaseCollection<web.Sdtsdt_variableValores_sdt_variableValoresItem>(web.Sdtsdt_variableValores_sdt_variableValoresItem.class, "sdt_variableValoresItem", "PayDay", remoteHandle);
      P01RN3_A3CliCod = new int[1] ;
      AV17OpeCliId = "" ;
      AV19OpeCliVig = GXutil.nullDate() ;
      AV20OpeCliVRetro = GXutil.nullDate() ;
      AV18OpeCliValor = "" ;
      AV26actualizadoOpeCliId = "" ;
      AV27actualizadoOpeCliVig = GXutil.nullDate() ;
      AV23auxOpeCliId = "" ;
      P01RN4_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01RN4_A82OpeCliId = new String[] {""} ;
      P01RN4_A1904OpeCliRelSecCli = new int[1] ;
      P01RN4_A3CliCod = new int[1] ;
      P01RN4_A1890OpeCliRelSec = new int[1] ;
      P01RN4_A535OpeCliValor = new String[] {""} ;
      P01RN4_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P01RN4_n1146OpeCliVRetro = new boolean[] {false} ;
      AV13hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      AV24maximoImponibleOpeCliId = "" ;
      AV25minimoImponibleOpeCliId = "" ;
      AV28proximaFecha = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      P01RN6_A1906OpeCliIdPadre = new String[] {""} ;
      P01RN6_A1903ValRelSecCli = new int[1] ;
      P01RN6_A3CliCod = new int[1] ;
      P01RN6_A82OpeCliId = new String[] {""} ;
      A1906OpeCliIdPadre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updatevariablevalores__default(),
         new Object[] {
             new Object[] {
            P01RN2_A1890OpeCliRelSec, P01RN2_A3CliCod, P01RN2_A82OpeCliId, P01RN2_A535OpeCliValor, P01RN2_A754OpeCliVig, P01RN2_A1146OpeCliVRetro, P01RN2_n1146OpeCliVRetro
            }
            , new Object[] {
            P01RN3_A3CliCod
            }
            , new Object[] {
            P01RN4_A754OpeCliVig, P01RN4_A82OpeCliId, P01RN4_A1904OpeCliRelSecCli, P01RN4_A3CliCod, P01RN4_A1890OpeCliRelSec, P01RN4_A535OpeCliValor, P01RN4_A1146OpeCliVRetro, P01RN4_n1146OpeCliVRetro
            }
            , new Object[] {
            }
            , new Object[] {
            P01RN6_A1906OpeCliIdPadre, P01RN6_A1903ValRelSecCli, P01RN6_A3CliCod, P01RN6_A82OpeCliId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV34GXLvl42 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11CliRelSec ;
   private int A1890OpeCliRelSec ;
   private int A3CliCod ;
   private int AV12hijoCliCod ;
   private int AV33GXV1 ;
   private int A1904OpeCliRelSecCli ;
   private int A1903ValRelSecCli ;
   private long AV9ClientePadre ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String AV17OpeCliId ;
   private String AV26actualizadoOpeCliId ;
   private String AV23auxOpeCliId ;
   private String AV24maximoImponibleOpeCliId ;
   private String AV25minimoImponibleOpeCliId ;
   private String A1906OpeCliIdPadre ;
   private java.util.Date AV21padreReleaseDateTime ;
   private java.util.Date AV13hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private java.util.Date AV19OpeCliVig ;
   private java.util.Date AV20OpeCliVRetro ;
   private java.util.Date AV27actualizadoOpeCliVig ;
   private java.util.Date AV28proximaFecha ;
   private java.util.Date GXv_date2[] ;
   private boolean n1146OpeCliVRetro ;
   private boolean returnInSub ;
   private String A535OpeCliValor ;
   private String AV18OpeCliValor ;
   private IDataStoreProvider pr_default ;
   private int[] P01RN2_A1890OpeCliRelSec ;
   private int[] P01RN2_A3CliCod ;
   private String[] P01RN2_A82OpeCliId ;
   private String[] P01RN2_A535OpeCliValor ;
   private java.util.Date[] P01RN2_A754OpeCliVig ;
   private java.util.Date[] P01RN2_A1146OpeCliVRetro ;
   private boolean[] P01RN2_n1146OpeCliVRetro ;
   private int[] P01RN3_A3CliCod ;
   private java.util.Date[] P01RN4_A754OpeCliVig ;
   private String[] P01RN4_A82OpeCliId ;
   private int[] P01RN4_A1904OpeCliRelSecCli ;
   private int[] P01RN4_A3CliCod ;
   private int[] P01RN4_A1890OpeCliRelSec ;
   private String[] P01RN4_A535OpeCliValor ;
   private java.util.Date[] P01RN4_A1146OpeCliVRetro ;
   private boolean[] P01RN4_n1146OpeCliVRetro ;
   private String[] P01RN6_A1906OpeCliIdPadre ;
   private int[] P01RN6_A1903ValRelSecCli ;
   private int[] P01RN6_A3CliCod ;
   private String[] P01RN6_A82OpeCliId ;
   private GXBaseCollection<web.Sdtsdt_variableValores_sdt_variableValoresItem> AV22sdt_variable ;
   private web.Sdtsdt_variableValores_sdt_variableValoresItem AV14itemVariable ;
}

final  class updatevariablevalores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV11CliRelSec ,
                                          int A1890OpeCliRelSec ,
                                          long AV9ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT OpeCliRelSec, CliCod, OpeCliId, OpeCliValor, OpeCliVig, OpeCliVRetro FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV11CliRelSec) )
      {
         addWhere(sWhereString, "(OpeCliRelSec = ?)");
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
                  return conditional_P01RN2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RN3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RN4", "SELECT OpeCliVig, OpeCliId, OpeCliRelSecCli, CliCod, OpeCliRelSec, OpeCliValor, OpeCliVRetro FROM variable_valores WHERE (CliCod = ? and OpeCliId = ( ?) and OpeCliVig = ?) AND (OpeCliRelSecCli = ?) ORDER BY CliCod, OpeCliId, OpeCliVig  FOR UPDATE OF variable_valores",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RN5", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliRelSecCli=?, OpeCliRelSec=?, OpeCliValor=?, OpeCliVRetro=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01RN6", "SELECT OpeCliIdPadre, ValRelSecCli, CliCod, OpeCliId FROM Variable WHERE (CliCod = ?) AND (ValRelSecCli = ?) AND (OpeCliIdPadre = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[4]);
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setString(6, (String)parms[6], 40);
               stmt.setDate(7, (java.util.Date)parms[7]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
      }
   }

}

