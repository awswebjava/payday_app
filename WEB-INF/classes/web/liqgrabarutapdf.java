package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqgrabarutapdf extends GXProcedure
{
   public liqgrabarutapdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqgrabarutapdf.class ), "" );
   }

   public liqgrabarutapdf( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      liqgrabarutapdf.this.AV8clicod = aP0;
      liqgrabarutapdf.this.AV11empcod = aP1;
      liqgrabarutapdf.this.AV9liqnro = aP2;
      liqgrabarutapdf.this.AV12LegNumero = aP3;
      liqgrabarutapdf.this.AV13tipoRecibo = aP4;
      liqgrabarutapdf.this.AV10liqrutapdf = aP5;
      liqgrabarutapdf.this.AV14LiqNombrePDF = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV18Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV12LegNumero, 8, 0))) ;
      if ( ! (0==AV12LegNumero) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV18Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " &empcod ", "")+GXutil.trim( GXutil.str( AV11empcod, 4, 0))+httpContext.getMessage( " liq ", "")+GXutil.trim( GXutil.str( AV9liqnro, 8, 0))) ;
         AV19GXLvl4 = (byte)(0) ;
         /* Using cursor P00KJ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV11empcod), Integer.valueOf(AV9liqnro), Integer.valueOf(AV12LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6LegNumero = P00KJ2_A6LegNumero[0] ;
            A31LiqNro = P00KJ2_A31LiqNro[0] ;
            A1EmpCod = P00KJ2_A1EmpCod[0] ;
            A3CliCod = P00KJ2_A3CliCod[0] ;
            A590LiqRutaPDF = P00KJ2_A590LiqRutaPDF[0] ;
            A961LiqNombrePDF = P00KJ2_A961LiqNombrePDF[0] ;
            A774LiqRutaPDFVertical = P00KJ2_A774LiqRutaPDFVertical[0] ;
            A962LiqNombrePDFVertical = P00KJ2_A962LiqNombrePDFVertical[0] ;
            AV19GXLvl4 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV18Pgmname, httpContext.getMessage( "&tipoRecibo ", "")+AV13tipoRecibo) ;
            if ( GXutil.strcmp(AV13tipoRecibo, "Apaisado") == 0 )
            {
               A590LiqRutaPDF = AV10liqrutapdf ;
               A961LiqNombrePDF = AV14LiqNombrePDF ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV18Pgmname, httpContext.getMessage( "act ", "")+AV10liqrutapdf+" ..... "+AV14LiqNombrePDF) ;
            }
            else
            {
               A774LiqRutaPDFVertical = AV10liqrutapdf ;
               A962LiqNombrePDFVertical = AV14LiqNombrePDF ;
            }
            /* Using cursor P00KJ3 */
            pr_default.execute(1, new Object[] {A590LiqRutaPDF, A961LiqNombrePDF, A774LiqRutaPDFVertical, A962LiqNombrePDFVertical, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV19GXLvl4 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV18Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      else
      {
         /* Using cursor P00KJ4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV11empcod), Integer.valueOf(AV9liqnro)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A31LiqNro = P00KJ4_A31LiqNro[0] ;
            A1EmpCod = P00KJ4_A1EmpCod[0] ;
            A3CliCod = P00KJ4_A3CliCod[0] ;
            A964LiqRutaPDFTodosHorizontal = P00KJ4_A964LiqRutaPDFTodosHorizontal[0] ;
            A966LiqRutaPDFTodosNombreHorizonta = P00KJ4_A966LiqRutaPDFTodosNombreHorizonta[0] ;
            A963LiqRutaPDFTodosVertical = P00KJ4_A963LiqRutaPDFTodosVertical[0] ;
            A965LiqRutaPDFTodosNombreVertical = P00KJ4_A965LiqRutaPDFTodosNombreVertical[0] ;
            if ( GXutil.strcmp(AV13tipoRecibo, "Apaisado") == 0 )
            {
               A964LiqRutaPDFTodosHorizontal = AV10liqrutapdf ;
               A966LiqRutaPDFTodosNombreHorizonta = AV14LiqNombrePDF ;
            }
            else
            {
               A963LiqRutaPDFTodosVertical = AV10liqrutapdf ;
               A965LiqRutaPDFTodosNombreVertical = AV14LiqNombrePDF ;
            }
            /* Using cursor P00KJ5 */
            pr_default.execute(3, new Object[] {A964LiqRutaPDFTodosHorizontal, A966LiqRutaPDFTodosNombreHorizonta, A963LiqRutaPDFTodosVertical, A965LiqRutaPDFTodosNombreVertical, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "liqgrabarutapdf");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18Pgmname = "" ;
      scmdbuf = "" ;
      P00KJ2_A6LegNumero = new int[1] ;
      P00KJ2_A31LiqNro = new int[1] ;
      P00KJ2_A1EmpCod = new short[1] ;
      P00KJ2_A3CliCod = new int[1] ;
      P00KJ2_A590LiqRutaPDF = new String[] {""} ;
      P00KJ2_A961LiqNombrePDF = new String[] {""} ;
      P00KJ2_A774LiqRutaPDFVertical = new String[] {""} ;
      P00KJ2_A962LiqNombrePDFVertical = new String[] {""} ;
      A590LiqRutaPDF = "" ;
      A961LiqNombrePDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A962LiqNombrePDFVertical = "" ;
      P00KJ4_A31LiqNro = new int[1] ;
      P00KJ4_A1EmpCod = new short[1] ;
      P00KJ4_A3CliCod = new int[1] ;
      P00KJ4_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      P00KJ4_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      P00KJ4_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      P00KJ4_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A963LiqRutaPDFTodosVertical = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqgrabarutapdf__default(),
         new Object[] {
             new Object[] {
            P00KJ2_A6LegNumero, P00KJ2_A31LiqNro, P00KJ2_A1EmpCod, P00KJ2_A3CliCod, P00KJ2_A590LiqRutaPDF, P00KJ2_A961LiqNombrePDF, P00KJ2_A774LiqRutaPDFVertical, P00KJ2_A962LiqNombrePDFVertical
            }
            , new Object[] {
            }
            , new Object[] {
            P00KJ4_A31LiqNro, P00KJ4_A1EmpCod, P00KJ4_A3CliCod, P00KJ4_A964LiqRutaPDFTodosHorizontal, P00KJ4_A966LiqRutaPDFTodosNombreHorizonta, P00KJ4_A963LiqRutaPDFTodosVertical, P00KJ4_A965LiqRutaPDFTodosNombreVertical
            }
            , new Object[] {
            }
         }
      );
      AV18Pgmname = "LiqGrabaRutaPDF" ;
      /* GeneXus formulas. */
      AV18Pgmname = "LiqGrabaRutaPDF" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19GXLvl4 ;
   private short AV11empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8clicod ;
   private int AV9liqnro ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV13tipoRecibo ;
   private String AV14LiqNombrePDF ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String A961LiqNombrePDF ;
   private String A962LiqNombrePDFVertical ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String AV10liqrutapdf ;
   private String A590LiqRutaPDF ;
   private String A774LiqRutaPDFVertical ;
   private String A964LiqRutaPDFTodosHorizontal ;
   private String A963LiqRutaPDFTodosVertical ;
   private IDataStoreProvider pr_default ;
   private int[] P00KJ2_A6LegNumero ;
   private int[] P00KJ2_A31LiqNro ;
   private short[] P00KJ2_A1EmpCod ;
   private int[] P00KJ2_A3CliCod ;
   private String[] P00KJ2_A590LiqRutaPDF ;
   private String[] P00KJ2_A961LiqNombrePDF ;
   private String[] P00KJ2_A774LiqRutaPDFVertical ;
   private String[] P00KJ2_A962LiqNombrePDFVertical ;
   private int[] P00KJ4_A31LiqNro ;
   private short[] P00KJ4_A1EmpCod ;
   private int[] P00KJ4_A3CliCod ;
   private String[] P00KJ4_A964LiqRutaPDFTodosHorizontal ;
   private String[] P00KJ4_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] P00KJ4_A963LiqRutaPDFTodosVertical ;
   private String[] P00KJ4_A965LiqRutaPDFTodosNombreVertical ;
}

final  class liqgrabarutapdf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KJ2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqRutaPDF, LiqNombrePDF, LiqRutaPDFVertical, LiqNombrePDFVertical FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00KJ3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqRutaPDF=?, LiqNombrePDF=?, LiqRutaPDFVertical=?, LiqNombrePDFVertical=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00KJ4", "SELECT LiqNro, EmpCod, CliCod, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreHorizonta, LiqRutaPDFTodosVertical, LiqRutaPDFTodosNombreVertical FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00KJ5", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqRutaPDFTodosHorizontal=?, LiqRutaPDFTodosNombreHorizonta=?, LiqRutaPDFTodosVertical=?, LiqRutaPDFTodosNombreVertical=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 200);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 200);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 200);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 200);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 200);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 200);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 200);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 200);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

