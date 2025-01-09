package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generarconceptosauxiliares extends GXProcedure
{
   public generarconceptosauxiliares( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generarconceptosauxiliares.class ), "" );
   }

   public generarconceptosauxiliares( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      generarconceptosauxiliares.this.AV15CliCod = aP0;
      generarconceptosauxiliares.this.AV16EmpCod = aP1;
      generarconceptosauxiliares.this.AV17LegNumero = aP2;
      generarconceptosauxiliares.this.AV8LiqNro = aP3;
      generarconceptosauxiliares.this.AV27ClientId = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV20revividosTiene ;
      new web.revivirapendientestodos(remoteHandle, context).execute( AV15CliCod, AV16EmpCod, AV8LiqNro, AV28dumLegNumero, GXv_boolean1) ;
      generarconceptosauxiliares.this.AV20revividosTiene = GXv_boolean1[0] ;
      AV22LiqAuxEstado = (byte)(3) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "1 &CliCod ", "")+GXutil.trim( GXutil.str( AV15CliCod, 6, 0))+httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV8LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV17LegNumero, 8, 0))) ;
      AV36GXLvl7 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8LiqNro) ,
                                           Integer.valueOf(AV17LegNumero) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV15CliCod) ,
                                           Short.valueOf(AV16EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01D42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV8LiqNro), Integer.valueOf(AV17LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01D42_A6LegNumero[0] ;
         A31LiqNro = P01D42_A31LiqNro[0] ;
         A1EmpCod = P01D42_A1EmpCod[0] ;
         A3CliCod = P01D42_A3CliCod[0] ;
         A32TLiqCod = P01D42_A32TLiqCod[0] ;
         n32TLiqCod = P01D42_n32TLiqCod[0] ;
         A283LiqPeriodo = P01D42_A283LiqPeriodo[0] ;
         A1781LiqLegErrorAux = P01D42_A1781LiqLegErrorAux[0] ;
         A1780LiqLegAuxEstado = P01D42_A1780LiqLegAuxEstado[0] ;
         A1157LiqLegImpContr = P01D42_A1157LiqLegImpContr[0] ;
         AV36GXLvl7 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "dentra!", "")) ;
         GXv_int2[0] = AV13ultimoLiqDSecuencial ;
         new web.ultimoliqdsecuencial(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, GXv_int2) ;
         generarconceptosauxiliares.this.AV13ultimoLiqDSecuencial = GXv_int2[0] ;
         AV26resolver = true ;
         GXv_char3[0] = "" ;
         GXv_boolean1[0] = AV19tienePendientes ;
         GXv_objcol_char4[0] = AV11segundo_plano ;
         GXv_int2[0] = AV12LiqDSecuencial ;
         GXv_boolean5[0] = AV14conceptosOK ;
         new web.genconcepsegundoplano_sincommit(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A32TLiqCod, A6LegNumero, true, A283LiqPeriodo, AV13ultimoLiqDSecuencial, AV26resolver, "", GXv_char3, GXv_boolean1, GXv_objcol_char4, GXv_int2, GXv_boolean5) ;
         generarconceptosauxiliares.this.AV19tienePendientes = GXv_boolean1[0] ;
         AV11segundo_plano = GXv_objcol_char4[0] ;
         generarconceptosauxiliares.this.AV12LiqDSecuencial = GXv_int2[0] ;
         generarconceptosauxiliares.this.AV14conceptosOK = GXv_boolean5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "!&conceptosOK ", "")+GXutil.trim( GXutil.booltostr( AV14conceptosOK))+httpContext.getMessage( " &tienePendientes ", "")+GXutil.trim( GXutil.booltostr( AV19tienePendientes))) ;
         if ( ! AV14conceptosOK && ! AV19tienePendientes )
         {
            GXt_char6 = A1781LiqLegErrorAux ;
            GXv_char3[0] = GXt_char6 ;
            new web.textoerrorgeneralliq(remoteHandle, context).execute( AV15CliCod, GXv_char3) ;
            generarconceptosauxiliares.this.GXt_char6 = GXv_char3[0] ;
            A1781LiqLegErrorAux = GXt_char6 ;
            A1780LiqLegAuxEstado = (byte)(2) ;
            AV22LiqAuxEstado = (byte)(2) ;
         }
         else
         {
            if ( ( AV19tienePendientes ) || ( AV20revividosTiene ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "1!") ;
               GXv_boolean5[0] = AV18errorCiclicoHay ;
               new web.procliquidacion2(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, (byte)(1), AV35Pgmname, false, "", GXv_boolean5) ;
               generarconceptosauxiliares.this.AV18errorCiclicoHay = GXv_boolean5[0] ;
               if ( AV18errorCiclicoHay )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "chau", "")) ;
                  GXt_char6 = A1781LiqLegErrorAux ;
                  GXv_char3[0] = GXt_char6 ;
                  new web.textoerrorciclico(remoteHandle, context).execute( AV15CliCod, GXv_char3) ;
                  generarconceptosauxiliares.this.GXt_char6 = GXv_char3[0] ;
                  A1781LiqLegErrorAux = GXt_char6 ;
                  A1780LiqLegAuxEstado = (byte)(2) ;
                  AV22LiqAuxEstado = (byte)(2) ;
               }
               else
               {
                  A1781LiqLegErrorAux = "" ;
                  A1780LiqLegAuxEstado = (byte)(3) ;
               }
            }
            else
            {
               A1781LiqLegErrorAux = "" ;
               A1780LiqLegAuxEstado = (byte)(3) ;
            }
         }
         if ( A1780LiqLegAuxEstado == 3 )
         {
            GXv_decimal7[0] = AV25LiqLegImpContr ;
            new web.liqlegsumarcontribuciones(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, GXv_decimal7) ;
            generarconceptosauxiliares.this.AV25LiqLegImpContr = GXv_decimal7[0] ;
            A1157LiqLegImpContr = AV25LiqLegImpContr ;
         }
         /* Using cursor P01D43 */
         pr_default.execute(1, new Object[] {A1781LiqLegErrorAux, Byte.valueOf(A1780LiqLegAuxEstado), A1157LiqLegImpContr, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl7 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "nnnn2n", "")) ;
      }
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV32sdt_leg_aux.size() )
      {
         AV31item = (web.Sdtsdt_leg_aux_sdt_leg_auxItem)((web.Sdtsdt_leg_aux_sdt_leg_auxItem)AV32sdt_leg_aux.elementAt(-1+AV37GXV1));
         AV30auxLegNumero = AV31item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero() ;
         AV38GXLvl79 = (byte)(0) ;
         /* Optimized UPDATE. */
         /* Using cursor P01D44 */
         pr_default.execute(2, new Object[] {AV31item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux(), Byte.valueOf(AV31item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado()), Integer.valueOf(AV15CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV8LiqNro), Integer.valueOf(AV30auxLegNumero)});
         if ( (pr_default.getStatus(2) != 101) )
         {
            AV38GXLvl79 = (byte)(1) ;
         }
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         /* End optimized UPDATE. */
         if ( AV38GXLvl79 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV15CliCod, AV35Pgmname, httpContext.getMessage( "nnnn2n!!!!!", "")) ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr())==0) )
         {
            AV39GXLvl92 = (byte)(0) ;
            /* Optimized UPDATE. */
            /* Using cursor P01D45 */
            pr_default.execute(3, new Object[] {AV31item.getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr(), Integer.valueOf(AV15CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV8LiqNro), Integer.valueOf(AV30auxLegNumero)});
            if ( (pr_default.getStatus(3) != 101) )
            {
               AV39GXLvl92 = (byte)(1) ;
            }
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            /* End optimized UPDATE. */
            if ( AV39GXLvl92 == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV15CliCod, AV35Pgmname, httpContext.getMessage( "nnnn33333333n!!!!!", "")) ;
            }
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "generarconceptosauxiliares");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28dumLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35Pgmname = "" ;
      scmdbuf = "" ;
      P01D42_A6LegNumero = new int[1] ;
      P01D42_A31LiqNro = new int[1] ;
      P01D42_A1EmpCod = new short[1] ;
      P01D42_A3CliCod = new int[1] ;
      P01D42_A32TLiqCod = new String[] {""} ;
      P01D42_n32TLiqCod = new boolean[] {false} ;
      P01D42_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01D42_A1781LiqLegErrorAux = new String[] {""} ;
      P01D42_A1780LiqLegAuxEstado = new byte[1] ;
      P01D42_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A1781LiqLegErrorAux = "" ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      AV11segundo_plano = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char4 = new GXSimpleCollection[1] ;
      GXv_int2 = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXt_char6 = "" ;
      GXv_char3 = new String[1] ;
      AV25LiqLegImpContr = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV32sdt_leg_aux = new GXBaseCollection<web.Sdtsdt_leg_aux_sdt_leg_auxItem>(web.Sdtsdt_leg_aux_sdt_leg_auxItem.class, "sdt_leg_auxItem", "PayDay", remoteHandle);
      AV31item = new web.Sdtsdt_leg_aux_sdt_leg_auxItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.generarconceptosauxiliares__default(),
         new Object[] {
             new Object[] {
            P01D42_A6LegNumero, P01D42_A31LiqNro, P01D42_A1EmpCod, P01D42_A3CliCod, P01D42_A32TLiqCod, P01D42_n32TLiqCod, P01D42_A283LiqPeriodo, P01D42_A1781LiqLegErrorAux, P01D42_A1780LiqLegAuxEstado, P01D42_A1157LiqLegImpContr
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV35Pgmname = "generarConceptosAuxiliares" ;
      /* GeneXus formulas. */
      AV35Pgmname = "generarConceptosAuxiliares" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22LiqAuxEstado ;
   private byte AV36GXLvl7 ;
   private byte A1780LiqLegAuxEstado ;
   private byte AV38GXLvl79 ;
   private byte AV39GXLvl92 ;
   private short AV16EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV17LegNumero ;
   private int AV8LiqNro ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV13ultimoLiqDSecuencial ;
   private int AV12LiqDSecuencial ;
   private int GXv_int2[] ;
   private int AV37GXV1 ;
   private int AV30auxLegNumero ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal AV25LiqLegImpContr ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV35Pgmname ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String GXt_char6 ;
   private String GXv_char3[] ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV20revividosTiene ;
   private boolean n32TLiqCod ;
   private boolean AV26resolver ;
   private boolean AV19tienePendientes ;
   private boolean GXv_boolean1[] ;
   private boolean AV14conceptosOK ;
   private boolean AV18errorCiclicoHay ;
   private boolean GXv_boolean5[] ;
   private String AV27ClientId ;
   private String A1781LiqLegErrorAux ;
   private GXSimpleCollection<Integer> AV28dumLegNumero ;
   private GXBaseCollection<web.Sdtsdt_leg_aux_sdt_leg_auxItem> AV32sdt_leg_aux ;
   private IDataStoreProvider pr_default ;
   private int[] P01D42_A6LegNumero ;
   private int[] P01D42_A31LiqNro ;
   private short[] P01D42_A1EmpCod ;
   private int[] P01D42_A3CliCod ;
   private String[] P01D42_A32TLiqCod ;
   private boolean[] P01D42_n32TLiqCod ;
   private java.util.Date[] P01D42_A283LiqPeriodo ;
   private String[] P01D42_A1781LiqLegErrorAux ;
   private byte[] P01D42_A1780LiqLegAuxEstado ;
   private java.math.BigDecimal[] P01D42_A1157LiqLegImpContr ;
   private GXSimpleCollection<String> AV11segundo_plano ;
   private GXSimpleCollection<String> GXv_objcol_char4[] ;
   private web.Sdtsdt_leg_aux_sdt_leg_auxItem AV31item ;
}

final  class generarconceptosauxiliares__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01D42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8LiqNro ,
                                          int AV17LegNumero ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          int AV15CliCod ,
                                          short AV16EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT LegNumero, LiqNro, EmpCod, CliCod, TLiqCod, LiqPeriodo, LiqLegErrorAux, LiqLegAuxEstado, LiqLegImpContr FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV8LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV17LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLegajo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01D42(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01D42", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01D43", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegErrorAux=?, LiqLegAuxEstado=?, LiqLegImpContr=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01D44", "UPDATE LiquidacionLegajo SET LiqLegErrorAux=?, LiqLegAuxEstado=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01D45", "UPDATE LiquidacionLegajo SET LiqLegImpContr=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 3 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

