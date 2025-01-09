package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getprccontrtipoempl extends GXProcedure
{
   public getprccontrtipoempl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getprccontrtipoempl.class ), "" );
   }

   public getprccontrtipoempl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      getprccontrtipoempl.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      getprccontrtipoempl.this.AV9CliCod = aP0;
      getprccontrtipoempl.this.AV10EmpCod = aP1;
      getprccontrtipoempl.this.AV8busqueda = aP2;
      getprccontrtipoempl.this.AV18LiqPeriodo = aP3;
      getprccontrtipoempl.this.AV19ProcesoLiquidacion = aP4;
      getprccontrtipoempl.this.aP5 = aP5;
      getprccontrtipoempl.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00J22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A45TipEmpleCod = P00J22_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00J22_n45TipEmpleCod[0] ;
         A1EmpCod = P00J22_A1EmpCod[0] ;
         A3CliCod = P00J22_A3CliCod[0] ;
         A530TipEmpleDefIns = P00J22_A530TipEmpleDefIns[0] ;
         A530TipEmpleDefIns = P00J22_A530TipEmpleDefIns[0] ;
         AV15TipEmpleDefIns = A530TipEmpleDefIns ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&TipEmpleDefIns ", "")+GXutil.trim( AV15TipEmpleDefIns)+httpContext.getMessage( " &BUSQUEDA \"", "")+GXutil.trim( AV8busqueda)+httpContext.getMessage( "\" &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV18LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV17OpeCliId = "[ley_27541_ali]" ;
      GXv_char1[0] = AV20ley_27541_aliVarcharJSON ;
      GXv_char2[0] = AV22auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV9CliCod, AV17OpeCliId, AV18LiqPeriodo, AV19ProcesoLiquidacion, GXv_char1, GXv_char2) ;
      getprccontrtipoempl.this.AV20ley_27541_aliVarcharJSON = GXv_char1[0] ;
      getprccontrtipoempl.this.AV22auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV22auxError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV21ley_27541_ali.fromJSonString(AV20ley_27541_aliVarcharJSON, null);
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&&&ley_27541_aliVarcharJSON ", "")+GXutil.trim( AV20ley_27541_aliVarcharJSON)) ;
      if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "JUBILACION", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "A") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Jubilacion_a() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ley_27541_ali.jubilacion_A ", "")+GXutil.trim( GXutil.str( AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Jubilacion_a(), 6, 4))) ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "JUBILACION", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "B") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Jubilacion_b() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ley_27541_ali.jubilacion_B ", "")+GXutil.trim( GXutil.str( AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Jubilacion_b(), 6, 4))) ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "PAMI", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "A") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Inssjyp_a() ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "PAMI", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "B") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Inssjyp_b() ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "AAFF", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "A") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Aaff_a() ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "AAFF", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "B") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Aaff_b() ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "FNE", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "A") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Fne_a() ;
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV8busqueda), httpContext.getMessage( "FNE", "")) == 0 ) && ( GXutil.strcmp(AV15TipEmpleDefIns, "B") == 0 ) )
      {
         AV16valor = AV21ley_27541_ali.getgxTv_Sdtley_27541_ali_Fne_b() ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "ENTRA POR OTHERWISE", "")) ;
      }
      new web.msgdebug6(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "BUSQUEDA ", "")+AV8busqueda+httpContext.getMessage( " valor ", "")+GXutil.trim( GXutil.str( AV16valor, 6, 4))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getprccontrtipoempl.this.AV16valor;
      this.aP6[0] = getprccontrtipoempl.this.AV22auxError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16valor = DecimalUtil.ZERO ;
      AV22auxError = "" ;
      scmdbuf = "" ;
      P00J22_A45TipEmpleCod = new String[] {""} ;
      P00J22_n45TipEmpleCod = new boolean[] {false} ;
      P00J22_A1EmpCod = new short[1] ;
      P00J22_A3CliCod = new int[1] ;
      P00J22_A530TipEmpleDefIns = new String[] {""} ;
      A45TipEmpleCod = "" ;
      A530TipEmpleDefIns = "" ;
      AV15TipEmpleDefIns = "" ;
      AV26Pgmname = "" ;
      AV17OpeCliId = "" ;
      AV20ley_27541_aliVarcharJSON = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV21ley_27541_ali = new web.Sdtley_27541_ali(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getprccontrtipoempl__default(),
         new Object[] {
             new Object[] {
            P00J22_A45TipEmpleCod, P00J22_n45TipEmpleCod, P00J22_A1EmpCod, P00J22_A3CliCod, P00J22_A530TipEmpleDefIns
            }
         }
      );
      AV26Pgmname = "getPrcContrTipoEmpl" ;
      /* GeneXus formulas. */
      AV26Pgmname = "getPrcContrTipoEmpl" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV16valor ;
   private String AV8busqueda ;
   private String AV19ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A45TipEmpleCod ;
   private String A530TipEmpleDefIns ;
   private String AV15TipEmpleDefIns ;
   private String AV26Pgmname ;
   private String AV17OpeCliId ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV18LiqPeriodo ;
   private boolean n45TipEmpleCod ;
   private boolean returnInSub ;
   private String AV22auxError ;
   private String AV20ley_27541_aliVarcharJSON ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00J22_A45TipEmpleCod ;
   private boolean[] P00J22_n45TipEmpleCod ;
   private short[] P00J22_A1EmpCod ;
   private int[] P00J22_A3CliCod ;
   private String[] P00J22_A530TipEmpleDefIns ;
   private web.Sdtley_27541_ali AV21ley_27541_ali ;
}

final  class getprccontrtipoempl__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00J22", "SELECT T1.TipEmpleCod, T1.EmpCod, T1.CliCod, T2.TipEmpleDefIns FROM (Empresa T1 LEFT JOIN TipoEmpleador T2 ON T2.TipEmpleCod = T1.TipEmpleCod) WHERE T1.CliCod = ? and T1.EmpCod = ? ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

