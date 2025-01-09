package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoopeformulasinmayusculas extends GXProcedure
{
   public codigoopeformulasinmayusculas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoopeformulasinmayusculas.class ), "" );
   }

   public codigoopeformulasinmayusculas( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      codigoopeformulasinmayusculas.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      codigoopeformulasinmayusculas.this.AV10clicod = aP0;
      codigoopeformulasinmayusculas.this.AV11idOperando = aP1;
      codigoopeformulasinmayusculas.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV9paicod ;
      new web.getpaicod(remoteHandle, context).execute( AV10clicod, GXv_int1) ;
      codigoopeformulasinmayusculas.this.AV9paicod = GXv_int1[0] ;
      /* Using cursor P00CG2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9paicod), AV11idOperando});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A74idOperando = P00CG2_A74idOperando[0] ;
         A46PaiCod = P00CG2_A46PaiCod[0] ;
         A473OpeCodFormula = P00CG2_A473OpeCodFormula[0] ;
         AV12codigoAux = A473OpeCodFormula ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV8codigo = GXutil.trim( AV12codigoAux) ;
      AV8codigo = GXutil.strReplace( AV8codigo, "[", "") ;
      AV8codigo = GXutil.strReplace( AV8codigo, "]", "") ;
      AV8codigo = GXutil.strReplace( AV8codigo, "{", "") ;
      AV8codigo = GXutil.strReplace( AV8codigo, "}", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = codigoopeformulasinmayusculas.this.AV8codigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8codigo = "" ;
      GXv_int1 = new short[1] ;
      scmdbuf = "" ;
      P00CG2_A74idOperando = new String[] {""} ;
      P00CG2_A46PaiCod = new short[1] ;
      P00CG2_A473OpeCodFormula = new String[] {""} ;
      A74idOperando = "" ;
      A473OpeCodFormula = "" ;
      AV12codigoAux = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.codigoopeformulasinmayusculas__default(),
         new Object[] {
             new Object[] {
            P00CG2_A74idOperando, P00CG2_A46PaiCod, P00CG2_A473OpeCodFormula
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9paicod ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10clicod ;
   private String AV11idOperando ;
   private String AV8codigo ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String A473OpeCodFormula ;
   private String AV12codigoAux ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00CG2_A74idOperando ;
   private short[] P00CG2_A46PaiCod ;
   private String[] P00CG2_A473OpeCodFormula ;
}

final  class codigoopeformulasinmayusculas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00CG2", "SELECT idOperando, PaiCod, OpeCodFormula FROM calculo WHERE PaiCod = ? and idOperando = ( ?) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

