package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class permitemodificacionformula extends GXProcedure
{
   public permitemodificacionformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( permitemodificacionformula.class ), "" );
   }

   public permitemodificacionformula( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 )
   {
      permitemodificacionformula.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      permitemodificacionformula.this.AV10CliCod = aP0;
      permitemodificacionformula.this.AV9ConCodigo = aP1;
      permitemodificacionformula.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P000X2_A26ConCodigo[0] ;
         A3CliCod = P000X2_A3CliCod[0] ;
         A921ConPadre = P000X2_A921ConPadre[0] ;
         n921ConPadre = P000X2_n921ConPadre[0] ;
         A1645ConceptoConveCodigo = P000X2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P000X2_n1645ConceptoConveCodigo[0] ;
         AV8permite = (boolean)((GXutil.strcmp("", A921ConPadre)==0)||P000X2_n921ConPadre[0]) ;
         if ( ! AV8permite )
         {
            GXv_boolean1[0] = AV11ClienteConveniador ;
            new web.getclienteconveniador(remoteHandle, context).execute( AV10CliCod, GXv_boolean1) ;
            permitemodificacionformula.this.AV11ClienteConveniador = GXv_boolean1[0] ;
            if ( AV11ClienteConveniador )
            {
               GXv_char2[0] = AV12ConveCodigo ;
               new web.getconvecodsesion(remoteHandle, context).execute( GXv_char2) ;
               permitemodificacionformula.this.AV12ConveCodigo = GXv_char2[0] ;
               if ( GXutil.strcmp(AV12ConveCodigo, A1645ConceptoConveCodigo) == 0 )
               {
                  AV8permite = true ;
               }
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = permitemodificacionformula.this.AV8permite;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P000X2_A26ConCodigo = new String[] {""} ;
      P000X2_A3CliCod = new int[1] ;
      P000X2_A921ConPadre = new String[] {""} ;
      P000X2_n921ConPadre = new boolean[] {false} ;
      P000X2_A1645ConceptoConveCodigo = new String[] {""} ;
      P000X2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A921ConPadre = "" ;
      A1645ConceptoConveCodigo = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV12ConveCodigo = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.permitemodificacionformula__default(),
         new Object[] {
             new Object[] {
            P000X2_A26ConCodigo, P000X2_A3CliCod, P000X2_A921ConPadre, P000X2_n921ConPadre, P000X2_A1645ConceptoConveCodigo, P000X2_n1645ConceptoConveCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A921ConPadre ;
   private String A1645ConceptoConveCodigo ;
   private String AV12ConveCodigo ;
   private String GXv_char2[] ;
   private boolean AV8permite ;
   private boolean n921ConPadre ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean AV11ClienteConveniador ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P000X2_A26ConCodigo ;
   private int[] P000X2_A3CliCod ;
   private String[] P000X2_A921ConPadre ;
   private boolean[] P000X2_n921ConPadre ;
   private String[] P000X2_A1645ConceptoConveCodigo ;
   private boolean[] P000X2_n1645ConceptoConveCodigo ;
}

final  class permitemodificacionformula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000X2", "SELECT ConCodigo, CliCod, ConPadre, ConceptoConveCodigo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
      }
   }

}

