package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustarsueldos extends GXProcedure
{
   public ajustarsueldos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustarsueldos.class ), "" );
   }

   public ajustarsueldos( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 )
   {
      ajustarsueldos.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<Integer> aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             String[] aP6 )
   {
      ajustarsueldos.this.AV16Clicod = aP0;
      ajustarsueldos.this.AV10EmpCod = aP1;
      ajustarsueldos.this.AV9LegNumero = aP2;
      ajustarsueldos.this.AV11origenFecha = aP3;
      ajustarsueldos.this.AV17nuevaFecha = aP4;
      ajustarsueldos.this.AV15porUnaje = aP5;
      ajustarsueldos.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( AV8i <= AV9LegNumero.size() )
      {
         GXv_char1[0] = AV12error ;
         GXv_decimal2[0] = AV13originalImportes ;
         GXv_char3[0] = AV18LegSuelTipo ;
         GXv_char4[0] = "" ;
         new web.obtsueldobasicomensual(remoteHandle, context).execute( AV16Clicod, AV10EmpCod, ((Number) AV9LegNumero.elementAt(-1+AV8i)).intValue(), 0, AV11origenFecha, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char1, GXv_decimal2, GXv_char3, GXv_char4) ;
         ajustarsueldos.this.AV12error = GXv_char1[0] ;
         ajustarsueldos.this.AV13originalImportes = GXv_decimal2[0] ;
         ajustarsueldos.this.AV18LegSuelTipo = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV12error)==0) )
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "ajustarsueldos");
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14nuevoImportes = GXutil.roundDecimal( AV13originalImportes.multiply(AV15porUnaje), 2) ;
         new web.newlegajo_sueldo(remoteHandle, context).execute( AV16Clicod, AV10EmpCod, ((Number) AV9LegNumero.elementAt(-1+AV8i)).intValue(), AV17nuevaFecha, AV14nuevoImportes, AV18LegSuelTipo) ;
         AV8i = (short)(AV8i+1) ;
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "ajustarsueldos");
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = ajustarsueldos.this.AV12error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12error = "" ;
      GXv_char1 = new String[1] ;
      AV13originalImportes = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV18LegSuelTipo = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV14nuevoImportes = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustarsueldos__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8i ;
   private short Gx_err ;
   private int AV16Clicod ;
   private java.math.BigDecimal AV15porUnaje ;
   private java.math.BigDecimal AV13originalImportes ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal AV14nuevoImportes ;
   private String GXv_char1[] ;
   private String AV18LegSuelTipo ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11origenFecha ;
   private java.util.Date AV17nuevaFecha ;
   private boolean returnInSub ;
   private String AV12error ;
   private GXSimpleCollection<Integer> AV9LegNumero ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
}

final  class ajustarsueldos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

