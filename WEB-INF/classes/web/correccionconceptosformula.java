package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class correccionconceptosformula extends GXProcedure
{
   public correccionconceptosformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( correccionconceptosformula.class ), "" );
   }

   public correccionconceptosformula( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        GXSimpleCollection<String> aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             GXSimpleCollection<String> aP2 )
   {
      correccionconceptosformula.this.AV15CliPadre = aP0;
      correccionconceptosformula.this.AV10CliCod = aP1;
      correccionconceptosformula.this.AV9ConCodigo = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV12conceptoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "{concepto}", false, true, GXv_char1) ;
      correccionconceptosformula.this.AV12conceptoPalabra = GXv_char1[0] ;
      AV8i = (short)(1) ;
      while ( AV8i <= AV9ConCodigo.size() )
      {
         AV11auxConCodigo = (String)AV9ConCodigo.elementAt(-1+AV8i) ;
         /* Using cursor P01PH2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV11auxConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A26ConCodigo = P01PH2_A26ConCodigo[0] ;
            A3CliCod = P01PH2_A3CliCod[0] ;
            A148ConFormula = P01PH2_A148ConFormula[0] ;
            n148ConFormula = P01PH2_n148ConFormula[0] ;
            AV13ConFormula = A148ConFormula ;
            /* Execute user subroutine: 'OPERANDOS' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV8i = (short)(AV8i+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'BUSCAR AUX PADRE' Routine */
      returnInSub = false ;
      AV17auxHijoConCodigo = "" ;
      /* Using cursor P01PH3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV15CliPadre), AV16ConPadre, Integer.valueOf(AV10CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A921ConPadre = P01PH3_A921ConPadre[0] ;
         n921ConPadre = P01PH3_n921ConPadre[0] ;
         A1822CliPadre = P01PH3_A1822CliPadre[0] ;
         n1822CliPadre = P01PH3_n1822CliPadre[0] ;
         A3CliCod = P01PH3_A3CliCod[0] ;
         A26ConCodigo = P01PH3_A26ConCodigo[0] ;
         AV17auxHijoConCodigo = GXutil.trim( A26ConCodigo) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void S121( )
   {
      /* 'OPERANDOS' Routine */
      returnInSub = false ;
      /* Using cursor P01PH4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod), AV11auxConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1823ConOpeConCodigo = P01PH4_A1823ConOpeConCodigo[0] ;
         n1823ConOpeConCodigo = P01PH4_n1823ConOpeConCodigo[0] ;
         A26ConCodigo = P01PH4_A26ConCodigo[0] ;
         A3CliCod = P01PH4_A3CliCod[0] ;
         A2119ConOpeId = P01PH4_A2119ConOpeId[0] ;
         A923ConOperFor = P01PH4_A923ConOperFor[0] ;
         AV16ConPadre = A1823ConOpeConCodigo ;
         /* Execute user subroutine: 'BUSCAR AUX PADRE' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(2);
            returnInSub = true;
            if (true) return;
         }
         if ( ! (GXutil.strcmp("", AV17auxHijoConCodigo)==0) )
         {
            AV13ConFormula = GXutil.strReplace( AV13ConFormula, "[ "+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( A1823ConOpeConCodigo)+"]", "[ "+GXutil.trim( AV12conceptoPalabra)+" "+GXutil.trim( AV17auxHijoConCodigo)+"]") ;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12conceptoPalabra = "" ;
      GXv_char1 = new String[1] ;
      AV11auxConCodigo = "" ;
      scmdbuf = "" ;
      P01PH2_A26ConCodigo = new String[] {""} ;
      P01PH2_A3CliCod = new int[1] ;
      P01PH2_A148ConFormula = new String[] {""} ;
      P01PH2_n148ConFormula = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      AV13ConFormula = "" ;
      AV17auxHijoConCodigo = "" ;
      AV16ConPadre = "" ;
      P01PH3_A921ConPadre = new String[] {""} ;
      P01PH3_n921ConPadre = new boolean[] {false} ;
      P01PH3_A1822CliPadre = new int[1] ;
      P01PH3_n1822CliPadre = new boolean[] {false} ;
      P01PH3_A3CliCod = new int[1] ;
      P01PH3_A26ConCodigo = new String[] {""} ;
      A921ConPadre = "" ;
      P01PH4_A1823ConOpeConCodigo = new String[] {""} ;
      P01PH4_n1823ConOpeConCodigo = new boolean[] {false} ;
      P01PH4_A26ConCodigo = new String[] {""} ;
      P01PH4_A3CliCod = new int[1] ;
      P01PH4_A2119ConOpeId = new String[] {""} ;
      P01PH4_A923ConOperFor = new String[] {""} ;
      A1823ConOpeConCodigo = "" ;
      A2119ConOpeId = "" ;
      A923ConOperFor = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.correccionconceptosformula__default(),
         new Object[] {
             new Object[] {
            P01PH2_A26ConCodigo, P01PH2_A3CliCod, P01PH2_A148ConFormula, P01PH2_n148ConFormula
            }
            , new Object[] {
            P01PH3_A921ConPadre, P01PH3_n921ConPadre, P01PH3_A1822CliPadre, P01PH3_n1822CliPadre, P01PH3_A3CliCod, P01PH3_A26ConCodigo
            }
            , new Object[] {
            P01PH4_A1823ConOpeConCodigo, P01PH4_n1823ConOpeConCodigo, P01PH4_A26ConCodigo, P01PH4_A3CliCod, P01PH4_A2119ConOpeId, P01PH4_A923ConOperFor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8i ;
   private short Gx_err ;
   private int AV15CliPadre ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int A1822CliPadre ;
   private String AV12conceptoPalabra ;
   private String GXv_char1[] ;
   private String AV11auxConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV17auxHijoConCodigo ;
   private String AV16ConPadre ;
   private String A921ConPadre ;
   private String A1823ConOpeConCodigo ;
   private String A2119ConOpeId ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean n921ConPadre ;
   private boolean n1822CliPadre ;
   private boolean n1823ConOpeConCodigo ;
   private String A148ConFormula ;
   private String AV13ConFormula ;
   private String A923ConOperFor ;
   private IDataStoreProvider pr_default ;
   private String[] P01PH2_A26ConCodigo ;
   private int[] P01PH2_A3CliCod ;
   private String[] P01PH2_A148ConFormula ;
   private boolean[] P01PH2_n148ConFormula ;
   private String[] P01PH3_A921ConPadre ;
   private boolean[] P01PH3_n921ConPadre ;
   private int[] P01PH3_A1822CliPadre ;
   private boolean[] P01PH3_n1822CliPadre ;
   private int[] P01PH3_A3CliCod ;
   private String[] P01PH3_A26ConCodigo ;
   private String[] P01PH4_A1823ConOpeConCodigo ;
   private boolean[] P01PH4_n1823ConOpeConCodigo ;
   private String[] P01PH4_A26ConCodigo ;
   private int[] P01PH4_A3CliCod ;
   private String[] P01PH4_A2119ConOpeId ;
   private String[] P01PH4_A923ConOperFor ;
   private GXSimpleCollection<String> AV9ConCodigo ;
}

final  class correccionconceptosformula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PH2", "SELECT ConCodigo, CliCod, ConFormula FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01PH3", "SELECT ConPadre, CliPadre, CliCod, ConCodigo FROM Concepto WHERE (CliPadre = ? and ConPadre = ( ?)) AND (CliCod = ?) ORDER BY CliPadre, ConPadre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PH4", "SELECT ConOpeConCodigo, ConCodigo, CliCod, ConOpeId, ConOperFor FROM concepto_operandos WHERE (CliCod = ? and ConCodigo = ( ?)) AND (Not (char_length(trim(trailing ' ' from ConOpeConCodigo))=0)) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 40);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

