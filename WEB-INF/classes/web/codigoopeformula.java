package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoopeformula extends GXProcedure
{
   public codigoopeformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoopeformula.class ), "" );
   }

   public codigoopeformula( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 )
   {
      codigoopeformula.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 ,
                             String[] aP4 )
   {
      codigoopeformula.this.AV10clicod = aP0;
      codigoopeformula.this.AV11idOperando = aP1;
      codigoopeformula.this.AV13mayusculas = aP2;
      codigoopeformula.this.AV14sinCorchetes = aP3;
      codigoopeformula.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV9paicod ;
      new web.getpaicod(remoteHandle, context).execute( AV10clicod, GXv_int1) ;
      codigoopeformula.this.AV9paicod = GXv_int1[0] ;
      AV12codigoAux = AV15websession.getValue(GXutil.trim( GXutil.str( AV9paicod, 4, 0))+"_"+GXutil.trim( AV11idOperando)) ;
      if ( (GXutil.strcmp("", AV12codigoAux)==0) )
      {
         /* Using cursor P001T2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV9paicod), AV11idOperando});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A74idOperando = P001T2_A74idOperando[0] ;
            A46PaiCod = P001T2_A46PaiCod[0] ;
            A473OpeCodFormula = P001T2_A473OpeCodFormula[0] ;
            AV12codigoAux = A473OpeCodFormula ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV15websession.setValue(GXutil.trim( GXutil.str( AV9paicod, 4, 0))+"_"+GXutil.trim( AV11idOperando), GXutil.trim( AV12codigoAux));
      }
      if ( AV13mayusculas )
      {
         AV8codigo = GXutil.trim( GXutil.upper( AV12codigoAux)) ;
      }
      else
      {
         AV8codigo = GXutil.trim( AV12codigoAux) ;
      }
      if ( AV14sinCorchetes )
      {
         GXv_char2[0] = AV8codigo ;
         new web.replacefinalconequis(remoteHandle, context).execute( GXv_char2) ;
         codigoopeformula.this.AV8codigo = GXv_char2[0] ;
         GXv_char2[0] = AV8codigo ;
         new web.replacecomienzo(remoteHandle, context).execute( GXv_char2) ;
         codigoopeformula.this.AV8codigo = GXv_char2[0] ;
         GXv_char2[0] = AV8codigo ;
         new web.replacefinal(remoteHandle, context).execute( GXv_char2) ;
         codigoopeformula.this.AV8codigo = GXv_char2[0] ;
      }
      new web.msgdebug6(remoteHandle, context).execute( AV19Pgmname, GXutil.trim( AV11idOperando)+httpContext.getMessage( " obtiene ", "")+AV8codigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = codigoopeformula.this.AV8codigo;
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
      AV12codigoAux = "" ;
      AV15websession = httpContext.getWebSession();
      scmdbuf = "" ;
      P001T2_A74idOperando = new String[] {""} ;
      P001T2_A46PaiCod = new short[1] ;
      P001T2_A473OpeCodFormula = new String[] {""} ;
      A74idOperando = "" ;
      A473OpeCodFormula = "" ;
      GXv_char2 = new String[1] ;
      AV19Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.codigoopeformula__default(),
         new Object[] {
             new Object[] {
            P001T2_A74idOperando, P001T2_A46PaiCod, P001T2_A473OpeCodFormula
            }
         }
      );
      AV19Pgmname = "codigoOpeFormula" ;
      /* GeneXus formulas. */
      AV19Pgmname = "codigoOpeFormula" ;
      Gx_err = (short)(0) ;
   }

   private short AV9paicod ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10clicod ;
   private String AV11idOperando ;
   private String AV8codigo ;
   private String AV12codigoAux ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String A473OpeCodFormula ;
   private String GXv_char2[] ;
   private String AV19Pgmname ;
   private boolean AV13mayusculas ;
   private boolean AV14sinCorchetes ;
   private com.genexus.webpanels.WebSession AV15websession ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P001T2_A74idOperando ;
   private short[] P001T2_A46PaiCod ;
   private String[] P001T2_A473OpeCodFormula ;
}

final  class codigoopeformula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001T2", "SELECT idOperando, PaiCod, OpeCodFormula FROM calculo WHERE PaiCod = ? and idOperando = ( ?) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

