package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqleggetnombrearchivopdf extends GXProcedure
{
   public liqleggetnombrearchivopdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqleggetnombrearchivopdf.class ), "" );
   }

   public liqleggetnombrearchivopdf( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      liqleggetnombrearchivopdf.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      liqleggetnombrearchivopdf.this.AV8clicod = aP0;
      liqleggetnombrearchivopdf.this.AV9empcod = aP1;
      liqleggetnombrearchivopdf.this.AV10liqnro = aP2;
      liqleggetnombrearchivopdf.this.AV11LegNumero = aP3;
      liqleggetnombrearchivopdf.this.AV12tipoRecibo = aP4;
      liqleggetnombrearchivopdf.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV17Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
      if ( ! (0==AV11LegNumero) )
      {
         if ( GXutil.strcmp(AV12tipoRecibo, "Apaisado") == 0 )
         {
            AV18GXLvl4 = (byte)(0) ;
            /* Using cursor P012G2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV10liqnro), Integer.valueOf(AV11LegNumero)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A6LegNumero = P012G2_A6LegNumero[0] ;
               A31LiqNro = P012G2_A31LiqNro[0] ;
               A1EmpCod = P012G2_A1EmpCod[0] ;
               A3CliCod = P012G2_A3CliCod[0] ;
               A961LiqNombrePDF = P012G2_A961LiqNombrePDF[0] ;
               AV18GXLvl4 = (byte)(1) ;
               AV14LiqNombrePDF = A961LiqNombrePDF ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
            if ( AV18GXLvl4 == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV17Pgmname, httpContext.getMessage( "apaisado none &clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9empcod, 4, 0))+httpContext.getMessage( " liq ", "")+GXutil.trim( GXutil.str( AV10liqnro, 8, 0))) ;
            }
         }
         else
         {
            AV19GXLvl14 = (byte)(0) ;
            /* Using cursor P012G3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV10liqnro), Integer.valueOf(AV11LegNumero)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A6LegNumero = P012G3_A6LegNumero[0] ;
               A31LiqNro = P012G3_A31LiqNro[0] ;
               A1EmpCod = P012G3_A1EmpCod[0] ;
               A3CliCod = P012G3_A3CliCod[0] ;
               A962LiqNombrePDFVertical = P012G3_A962LiqNombrePDFVertical[0] ;
               AV19GXLvl14 = (byte)(1) ;
               AV14LiqNombrePDF = A962LiqNombrePDFVertical ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            if ( AV19GXLvl14 == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV17Pgmname, httpContext.getMessage( "none &clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9empcod, 4, 0))+httpContext.getMessage( " liq ", "")+GXutil.trim( GXutil.str( AV10liqnro, 8, 0))) ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV17Pgmname, httpContext.getMessage( "&LiqNombrePDF ", "")+AV14LiqNombrePDF) ;
      }
      else
      {
         /* Using cursor P012G4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV10liqnro)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A31LiqNro = P012G4_A31LiqNro[0] ;
            A1EmpCod = P012G4_A1EmpCod[0] ;
            A3CliCod = P012G4_A3CliCod[0] ;
            A966LiqRutaPDFTodosNombreHorizonta = P012G4_A966LiqRutaPDFTodosNombreHorizonta[0] ;
            A965LiqRutaPDFTodosNombreVertical = P012G4_A965LiqRutaPDFTodosNombreVertical[0] ;
            if ( GXutil.strcmp(AV12tipoRecibo, "Apaisado") == 0 )
            {
               AV14LiqNombrePDF = A966LiqRutaPDFTodosNombreHorizonta ;
            }
            else
            {
               AV14LiqNombrePDF = A965LiqRutaPDFTodosNombreVertical ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = liqleggetnombrearchivopdf.this.AV14LiqNombrePDF;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14LiqNombrePDF = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P012G2_A6LegNumero = new int[1] ;
      P012G2_A31LiqNro = new int[1] ;
      P012G2_A1EmpCod = new short[1] ;
      P012G2_A3CliCod = new int[1] ;
      P012G2_A961LiqNombrePDF = new String[] {""} ;
      A961LiqNombrePDF = "" ;
      P012G3_A6LegNumero = new int[1] ;
      P012G3_A31LiqNro = new int[1] ;
      P012G3_A1EmpCod = new short[1] ;
      P012G3_A3CliCod = new int[1] ;
      P012G3_A962LiqNombrePDFVertical = new String[] {""} ;
      A962LiqNombrePDFVertical = "" ;
      P012G4_A31LiqNro = new int[1] ;
      P012G4_A1EmpCod = new short[1] ;
      P012G4_A3CliCod = new int[1] ;
      P012G4_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      P012G4_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqleggetnombrearchivopdf__default(),
         new Object[] {
             new Object[] {
            P012G2_A6LegNumero, P012G2_A31LiqNro, P012G2_A1EmpCod, P012G2_A3CliCod, P012G2_A961LiqNombrePDF
            }
            , new Object[] {
            P012G3_A6LegNumero, P012G3_A31LiqNro, P012G3_A1EmpCod, P012G3_A3CliCod, P012G3_A962LiqNombrePDFVertical
            }
            , new Object[] {
            P012G4_A31LiqNro, P012G4_A1EmpCod, P012G4_A3CliCod, P012G4_A966LiqRutaPDFTodosNombreHorizonta, P012G4_A965LiqRutaPDFTodosNombreVertical
            }
         }
      );
      AV17Pgmname = "LiqLegGetNombreArchivoPDF" ;
      /* GeneXus formulas. */
      AV17Pgmname = "LiqLegGetNombreArchivoPDF" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl4 ;
   private byte AV19GXLvl14 ;
   private short AV9empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8clicod ;
   private int AV10liqnro ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV12tipoRecibo ;
   private String AV14LiqNombrePDF ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A961LiqNombrePDF ;
   private String A962LiqNombrePDFVertical ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P012G2_A6LegNumero ;
   private int[] P012G2_A31LiqNro ;
   private short[] P012G2_A1EmpCod ;
   private int[] P012G2_A3CliCod ;
   private String[] P012G2_A961LiqNombrePDF ;
   private int[] P012G3_A6LegNumero ;
   private int[] P012G3_A31LiqNro ;
   private short[] P012G3_A1EmpCod ;
   private int[] P012G3_A3CliCod ;
   private String[] P012G3_A962LiqNombrePDFVertical ;
   private int[] P012G4_A31LiqNro ;
   private short[] P012G4_A1EmpCod ;
   private int[] P012G4_A3CliCod ;
   private String[] P012G4_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] P012G4_A965LiqRutaPDFTodosNombreVertical ;
}

final  class liqleggetnombrearchivopdf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012G2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqNombrePDF FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P012G3", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqNombrePDFVertical FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P012G4", "SELECT LiqNro, EmpCod, CliCod, LiqRutaPDFTodosNombreHorizonta, LiqRutaPDFTodosNombreVertical FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 200);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 200);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 200);
               ((String[]) buf[4])[0] = rslt.getString(5, 200);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

