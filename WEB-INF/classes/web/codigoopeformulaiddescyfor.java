package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoopeformulaiddescyfor extends GXProcedure
{
   public codigoopeformulaiddescyfor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoopeformulaiddescyfor.class ), "" );
   }

   public codigoopeformulaiddescyfor( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              String[] aP3 ,
                              String[] aP4 ,
                              boolean[] aP5 )
   {
      codigoopeformulaiddescyfor.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 )
   {
      codigoopeformulaiddescyfor.this.AV8clicod = aP0;
      codigoopeformulaiddescyfor.this.AV13OpeCodForMay = aP1;
      codigoopeformulaiddescyfor.this.aP2 = aP2;
      codigoopeformulaiddescyfor.this.aP3 = aP3;
      codigoopeformulaiddescyfor.this.aP4 = aP4;
      codigoopeformulaiddescyfor.this.aP5 = aP5;
      codigoopeformulaiddescyfor.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV14paicod ;
      new web.getpaicod(remoteHandle, context).execute( AV8clicod, GXv_int1) ;
      codigoopeformulaiddescyfor.this.AV14paicod = GXv_int1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&paicod ", "")+GXutil.trim( GXutil.str( AV14paicod, 4, 0))+httpContext.getMessage( " &OpeCodForMay ", "")+GXutil.trim( AV13OpeCodForMay)) ;
      AV24GXLvl3 = (byte)(0) ;
      /* Using cursor P010Q2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV14paicod), AV13OpeCodForMay});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A537OpeCodForMay = P010Q2_A537OpeCodForMay[0] ;
         A46PaiCod = P010Q2_A46PaiCod[0] ;
         A74idOperando = P010Q2_A74idOperando[0] ;
         A474OpeDescripcion = P010Q2_A474OpeDescripcion[0] ;
         A473OpeCodFormula = P010Q2_A473OpeCodFormula[0] ;
         A932OpeEsCant = P010Q2_A932OpeEsCant[0] ;
         A1032OpeAliEs = P010Q2_A1032OpeAliEs[0] ;
         AV24GXLvl3 = (byte)(1) ;
         AV11idOperando = A74idOperando ;
         AV17OpeDescripcion = A474OpeDescripcion ;
         AV18OpeCodFormula = A473OpeCodFormula ;
         AV19OpeEsCant = A932OpeEsCant ;
         AV20OpeAliEs = A1032OpeAliEs ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV24GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = codigoopeformulaiddescyfor.this.AV11idOperando;
      this.aP3[0] = codigoopeformulaiddescyfor.this.AV17OpeDescripcion;
      this.aP4[0] = codigoopeformulaiddescyfor.this.AV18OpeCodFormula;
      this.aP5[0] = codigoopeformulaiddescyfor.this.AV19OpeEsCant;
      this.aP6[0] = codigoopeformulaiddescyfor.this.AV20OpeAliEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11idOperando = "" ;
      AV17OpeDescripcion = "" ;
      AV18OpeCodFormula = "" ;
      GXv_int1 = new short[1] ;
      AV23Pgmname = "" ;
      scmdbuf = "" ;
      P010Q2_A537OpeCodForMay = new String[] {""} ;
      P010Q2_A46PaiCod = new short[1] ;
      P010Q2_A74idOperando = new String[] {""} ;
      P010Q2_A474OpeDescripcion = new String[] {""} ;
      P010Q2_A473OpeCodFormula = new String[] {""} ;
      P010Q2_A932OpeEsCant = new boolean[] {false} ;
      P010Q2_A1032OpeAliEs = new boolean[] {false} ;
      A537OpeCodForMay = "" ;
      A74idOperando = "" ;
      A474OpeDescripcion = "" ;
      A473OpeCodFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.codigoopeformulaiddescyfor__default(),
         new Object[] {
             new Object[] {
            P010Q2_A537OpeCodForMay, P010Q2_A46PaiCod, P010Q2_A74idOperando, P010Q2_A474OpeDescripcion, P010Q2_A473OpeCodFormula, P010Q2_A932OpeEsCant, P010Q2_A1032OpeAliEs
            }
         }
      );
      AV23Pgmname = "codigoOpeFormulaIdDescYFor" ;
      /* GeneXus formulas. */
      AV23Pgmname = "codigoOpeFormulaIdDescYFor" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24GXLvl3 ;
   private short AV14paicod ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV8clicod ;
   private String AV13OpeCodForMay ;
   private String AV11idOperando ;
   private String AV18OpeCodFormula ;
   private String AV23Pgmname ;
   private String scmdbuf ;
   private String A537OpeCodForMay ;
   private String A74idOperando ;
   private String A473OpeCodFormula ;
   private boolean AV19OpeEsCant ;
   private boolean AV20OpeAliEs ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private String AV17OpeDescripcion ;
   private String A474OpeDescripcion ;
   private boolean[] aP6 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P010Q2_A537OpeCodForMay ;
   private short[] P010Q2_A46PaiCod ;
   private String[] P010Q2_A74idOperando ;
   private String[] P010Q2_A474OpeDescripcion ;
   private String[] P010Q2_A473OpeCodFormula ;
   private boolean[] P010Q2_A932OpeEsCant ;
   private boolean[] P010Q2_A1032OpeAliEs ;
}

final  class codigoopeformulaiddescyfor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P010Q2", "SELECT OpeCodForMay, PaiCod, idOperando, OpeDescripcion, OpeCodFormula, OpeEsCant, OpeAliEs FROM calculo WHERE PaiCod = ? and OpeCodForMay = ( ?) ORDER BY PaiCod, OpeCodForMay  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
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

