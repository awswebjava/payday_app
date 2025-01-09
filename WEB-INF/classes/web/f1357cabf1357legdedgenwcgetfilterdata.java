package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class f1357cabf1357legdedgenwcgetfilterdata extends GXProcedure
{
   public f1357cabf1357legdedgenwcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cabf1357legdedgenwcgetfilterdata.class ), "" );
   }

   public f1357cabf1357legdedgenwcgetfilterdata( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      f1357cabf1357legdedgenwcgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      f1357cabf1357legdedgenwcgetfilterdata.this.AV19DDOName = aP0;
      f1357cabf1357legdedgenwcgetfilterdata.this.AV17SearchTxt = aP1;
      f1357cabf1357legdedgenwcgetfilterdata.this.AV18SearchTxtTo = aP2;
      f1357cabf1357legdedgenwcgetfilterdata.this.aP3 = aP3;
      f1357cabf1357legdedgenwcgetfilterdata.this.aP4 = aP4;
      f1357cabf1357legdedgenwcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab", GXv_boolean2) ;
      f1357cabf1357legdedgenwcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_LEGIDNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGIDNOMAPEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_F1357LDGDESCUENTOSLEY") == 0 )
         {
            /* Execute user subroutine: 'LOADF1357LDGDESCUENTOSLEYOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_F1357LDGOTRDESCULEY") == 0 )
         {
            /* Execute user subroutine: 'LOADF1357LDGOTRDESCULEYOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV23OptionsJson = AV22Options.toJSonString(false) ;
      AV26OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV28OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("F1357CabF1357LegDedGenWCGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "F1357CabF1357LegDedGenWCGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("F1357CabF1357LegDedGenWCGridState"), null, null);
      }
      AV45GXV1 = 1 ;
      while ( AV45GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV45GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV40TFLegIdNomApe = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV39TFLegIdNomApe_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFLegIdNomApe_Sels.fromJSonString(AV39TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGDESCUENTOSLEY") == 0 )
         {
            AV12TFF1357LDGDescuentosLey = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGDESCUENTOSLEY_SEL") == 0 )
         {
            AV11TFF1357LDGDescuentosLey_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFF1357LDGDescuentosLey_Sels.fromJSonString(AV11TFF1357LDGDescuentosLey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGOTRDESCULEY") == 0 )
         {
            AV15TFF1357LDGOtrDescuLey = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGOTRDESCULEY_SEL") == 0 )
         {
            AV14TFF1357LDGOtrDescuLey_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFF1357LDGOtrDescuLey_Sels.fromJSonString(AV14TFF1357LDGOtrDescuLey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV35CliCod = (int)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV36EmpCod = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CTIPOPRE") == 0 )
         {
            AV42F1357CTipoPre = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CPER") == 0 )
         {
            AV37F1357CPer = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&F1357CSEC") == 0 )
         {
            AV38F1357CSec = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV45GXV1 = (int)(AV45GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV40TFLegIdNomApe = AV17SearchTxt ;
      AV41TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV41TFLegIdNomApe_Sels ,
                                           A825F1357LDGDescuentosLey ,
                                           AV13TFF1357LDGDescuentosLey_Sels ,
                                           A826F1357LDGOtrDescuLey ,
                                           AV16TFF1357LDGOtrDescuLey_Sels ,
                                           Integer.valueOf(AV41TFLegIdNomApe_Sels.size()) ,
                                           AV40TFLegIdNomApe ,
                                           Integer.valueOf(AV13TFF1357LDGDescuentosLey_Sels.size()) ,
                                           AV12TFF1357LDGDescuentosLey ,
                                           Integer.valueOf(AV16TFF1357LDGOtrDescuLey_Sels.size()) ,
                                           AV15TFF1357LDGOtrDescuLey ,
                                           Integer.valueOf(AV35CliCod) ,
                                           Short.valueOf(AV36EmpCod) ,
                                           Byte.valueOf(AV42F1357CTipoPre) ,
                                           AV37F1357CPer ,
                                           Byte.valueOf(AV38F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           A777F1357CPer ,
                                           Byte.valueOf(A778F1357CSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV40TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV40TFLegIdNomApe), "%", "") ;
      lV12TFF1357LDGDescuentosLey = GXutil.concat( GXutil.rtrim( AV12TFF1357LDGDescuentosLey), "%", "") ;
      lV15TFF1357LDGOtrDescuLey = GXutil.concat( GXutil.rtrim( AV15TFF1357LDGOtrDescuLey), "%", "") ;
      /* Using cursor P00V22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV35CliCod), Short.valueOf(AV36EmpCod), Byte.valueOf(AV42F1357CTipoPre), AV37F1357CPer, Byte.valueOf(AV38F1357CSec), lV40TFLegIdNomApe, lV12TFF1357LDGDescuentosLey, lV15TFF1357LDGOtrDescuLey});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00V22_A6LegNumero[0] ;
         A826F1357LDGOtrDescuLey = P00V22_A826F1357LDGOtrDescuLey[0] ;
         A825F1357LDGDescuentosLey = P00V22_A825F1357LDGDescuentosLey[0] ;
         A250LegIdNomApe = P00V22_A250LegIdNomApe[0] ;
         A778F1357CSec = P00V22_A778F1357CSec[0] ;
         A777F1357CPer = P00V22_A777F1357CPer[0] ;
         A784F1357CTipoPre = P00V22_A784F1357CTipoPre[0] ;
         A1EmpCod = P00V22_A1EmpCod[0] ;
         A3CliCod = P00V22_A3CliCod[0] ;
         A863F1357LDGTipReg = P00V22_A863F1357LDGTipReg[0] ;
         A250LegIdNomApe = P00V22_A250LegIdNomApe[0] ;
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV21Option = A250LegIdNomApe ;
            AV20InsertIndex = 1 ;
            while ( ( AV20InsertIndex <= AV22Options.size() ) && ( GXutil.strcmp((String)AV22Options.elementAt(-1+AV20InsertIndex), AV21Option) < 0 ) )
            {
               AV20InsertIndex = (int)(AV20InsertIndex+1) ;
            }
            if ( ( AV20InsertIndex <= AV22Options.size() ) && ( GXutil.strcmp((String)AV22Options.elementAt(-1+AV20InsertIndex), AV21Option) == 0 ) )
            {
               AV29count = GXutil.lval( (String)AV27OptionIndexes.elementAt(-1+AV20InsertIndex)) ;
               AV29count = (long)(AV29count+1) ;
               AV27OptionIndexes.removeItem(AV20InsertIndex);
               AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), AV20InsertIndex);
            }
            else
            {
               AV22Options.add(AV21Option, AV20InsertIndex);
               AV27OptionIndexes.add("1", AV20InsertIndex);
            }
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADF1357LDGDESCUENTOSLEYOPTIONS' Routine */
      returnInSub = false ;
      AV12TFF1357LDGDescuentosLey = AV17SearchTxt ;
      AV13TFF1357LDGDescuentosLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV41TFLegIdNomApe_Sels ,
                                           A825F1357LDGDescuentosLey ,
                                           AV13TFF1357LDGDescuentosLey_Sels ,
                                           A826F1357LDGOtrDescuLey ,
                                           AV16TFF1357LDGOtrDescuLey_Sels ,
                                           Integer.valueOf(AV41TFLegIdNomApe_Sels.size()) ,
                                           AV40TFLegIdNomApe ,
                                           Integer.valueOf(AV13TFF1357LDGDescuentosLey_Sels.size()) ,
                                           AV12TFF1357LDGDescuentosLey ,
                                           Integer.valueOf(AV16TFF1357LDGOtrDescuLey_Sels.size()) ,
                                           AV15TFF1357LDGOtrDescuLey ,
                                           Integer.valueOf(AV35CliCod) ,
                                           Short.valueOf(AV36EmpCod) ,
                                           Byte.valueOf(AV42F1357CTipoPre) ,
                                           AV37F1357CPer ,
                                           Byte.valueOf(AV38F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           A777F1357CPer ,
                                           Byte.valueOf(A778F1357CSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV40TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV40TFLegIdNomApe), "%", "") ;
      lV12TFF1357LDGDescuentosLey = GXutil.concat( GXutil.rtrim( AV12TFF1357LDGDescuentosLey), "%", "") ;
      lV15TFF1357LDGOtrDescuLey = GXutil.concat( GXutil.rtrim( AV15TFF1357LDGOtrDescuLey), "%", "") ;
      /* Using cursor P00V23 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV35CliCod), Short.valueOf(AV36EmpCod), Byte.valueOf(AV42F1357CTipoPre), AV37F1357CPer, Byte.valueOf(AV38F1357CSec), lV40TFLegIdNomApe, lV12TFF1357LDGDescuentosLey, lV15TFF1357LDGOtrDescuLey});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkV23 = false ;
         A6LegNumero = P00V23_A6LegNumero[0] ;
         A3CliCod = P00V23_A3CliCod[0] ;
         A1EmpCod = P00V23_A1EmpCod[0] ;
         A784F1357CTipoPre = P00V23_A784F1357CTipoPre[0] ;
         A777F1357CPer = P00V23_A777F1357CPer[0] ;
         A778F1357CSec = P00V23_A778F1357CSec[0] ;
         A825F1357LDGDescuentosLey = P00V23_A825F1357LDGDescuentosLey[0] ;
         A826F1357LDGOtrDescuLey = P00V23_A826F1357LDGOtrDescuLey[0] ;
         A250LegIdNomApe = P00V23_A250LegIdNomApe[0] ;
         A863F1357LDGTipReg = P00V23_A863F1357LDGTipReg[0] ;
         A250LegIdNomApe = P00V23_A250LegIdNomApe[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00V23_A3CliCod[0] == A3CliCod ) && ( P00V23_A1EmpCod[0] == A1EmpCod ) && ( P00V23_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( GXutil.strcmp(P00V23_A777F1357CPer[0], A777F1357CPer) == 0 ) )
         {
            if ( ! ( ( P00V23_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(P00V23_A825F1357LDGDescuentosLey[0], A825F1357LDGDescuentosLey) == 0 ) ) )
            {
               if (true) break;
            }
            brkV23 = false ;
            A6LegNumero = P00V23_A6LegNumero[0] ;
            A863F1357LDGTipReg = P00V23_A863F1357LDGTipReg[0] ;
            AV29count = (long)(AV29count+1) ;
            brkV23 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A825F1357LDGDescuentosLey)==0) )
         {
            AV21Option = A825F1357LDGDescuentosLey ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkV23 )
         {
            brkV23 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADF1357LDGOTRDESCULEYOPTIONS' Routine */
      returnInSub = false ;
      AV15TFF1357LDGOtrDescuLey = AV17SearchTxt ;
      AV16TFF1357LDGOtrDescuLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV41TFLegIdNomApe_Sels ,
                                           A825F1357LDGDescuentosLey ,
                                           AV13TFF1357LDGDescuentosLey_Sels ,
                                           A826F1357LDGOtrDescuLey ,
                                           AV16TFF1357LDGOtrDescuLey_Sels ,
                                           Integer.valueOf(AV41TFLegIdNomApe_Sels.size()) ,
                                           AV40TFLegIdNomApe ,
                                           Integer.valueOf(AV13TFF1357LDGDescuentosLey_Sels.size()) ,
                                           AV12TFF1357LDGDescuentosLey ,
                                           Integer.valueOf(AV16TFF1357LDGOtrDescuLey_Sels.size()) ,
                                           AV15TFF1357LDGOtrDescuLey ,
                                           Integer.valueOf(AV35CliCod) ,
                                           Short.valueOf(AV36EmpCod) ,
                                           Byte.valueOf(AV42F1357CTipoPre) ,
                                           AV37F1357CPer ,
                                           Byte.valueOf(AV38F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           A777F1357CPer ,
                                           Byte.valueOf(A778F1357CSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE
                                           }
      });
      lV40TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV40TFLegIdNomApe), "%", "") ;
      lV12TFF1357LDGDescuentosLey = GXutil.concat( GXutil.rtrim( AV12TFF1357LDGDescuentosLey), "%", "") ;
      lV15TFF1357LDGOtrDescuLey = GXutil.concat( GXutil.rtrim( AV15TFF1357LDGOtrDescuLey), "%", "") ;
      /* Using cursor P00V24 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV35CliCod), Short.valueOf(AV36EmpCod), Byte.valueOf(AV42F1357CTipoPre), AV37F1357CPer, Byte.valueOf(AV38F1357CSec), lV40TFLegIdNomApe, lV12TFF1357LDGDescuentosLey, lV15TFF1357LDGOtrDescuLey});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brkV25 = false ;
         A6LegNumero = P00V24_A6LegNumero[0] ;
         A3CliCod = P00V24_A3CliCod[0] ;
         A1EmpCod = P00V24_A1EmpCod[0] ;
         A784F1357CTipoPre = P00V24_A784F1357CTipoPre[0] ;
         A777F1357CPer = P00V24_A777F1357CPer[0] ;
         A778F1357CSec = P00V24_A778F1357CSec[0] ;
         A826F1357LDGOtrDescuLey = P00V24_A826F1357LDGOtrDescuLey[0] ;
         A825F1357LDGDescuentosLey = P00V24_A825F1357LDGDescuentosLey[0] ;
         A250LegIdNomApe = P00V24_A250LegIdNomApe[0] ;
         A863F1357LDGTipReg = P00V24_A863F1357LDGTipReg[0] ;
         A250LegIdNomApe = P00V24_A250LegIdNomApe[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P00V24_A3CliCod[0] == A3CliCod ) && ( P00V24_A1EmpCod[0] == A1EmpCod ) && ( P00V24_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( GXutil.strcmp(P00V24_A777F1357CPer[0], A777F1357CPer) == 0 ) )
         {
            if ( ! ( ( P00V24_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(P00V24_A826F1357LDGOtrDescuLey[0], A826F1357LDGOtrDescuLey) == 0 ) ) )
            {
               if (true) break;
            }
            brkV25 = false ;
            A6LegNumero = P00V24_A6LegNumero[0] ;
            A863F1357LDGTipReg = P00V24_A863F1357LDGTipReg[0] ;
            AV29count = (long)(AV29count+1) ;
            brkV25 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A826F1357LDGOtrDescuLey)==0) )
         {
            AV21Option = A826F1357LDGOtrDescuLey ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkV25 )
         {
            brkV25 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = f1357cabf1357legdedgenwcgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = f1357cabf1357legdedgenwcgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = f1357cabf1357legdedgenwcgetfilterdata.this.AV28OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23OptionsJson = "" ;
      AV26OptionsDescJson = "" ;
      AV28OptionIndexesJson = "" ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV40TFLegIdNomApe = "" ;
      AV39TFLegIdNomApe_SelsJson = "" ;
      AV41TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFF1357LDGDescuentosLey = "" ;
      AV11TFF1357LDGDescuentosLey_SelsJson = "" ;
      AV13TFF1357LDGDescuentosLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFF1357LDGOtrDescuLey = "" ;
      AV14TFF1357LDGOtrDescuLey_SelsJson = "" ;
      AV16TFF1357LDGOtrDescuLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37F1357CPer = "" ;
      scmdbuf = "" ;
      lV40TFLegIdNomApe = "" ;
      lV12TFF1357LDGDescuentosLey = "" ;
      lV15TFF1357LDGOtrDescuLey = "" ;
      A250LegIdNomApe = "" ;
      A825F1357LDGDescuentosLey = "" ;
      A826F1357LDGOtrDescuLey = "" ;
      A777F1357CPer = "" ;
      P00V22_A6LegNumero = new int[1] ;
      P00V22_A826F1357LDGOtrDescuLey = new String[] {""} ;
      P00V22_A825F1357LDGDescuentosLey = new String[] {""} ;
      P00V22_A250LegIdNomApe = new String[] {""} ;
      P00V22_A778F1357CSec = new byte[1] ;
      P00V22_A777F1357CPer = new String[] {""} ;
      P00V22_A784F1357CTipoPre = new byte[1] ;
      P00V22_A1EmpCod = new short[1] ;
      P00V22_A3CliCod = new int[1] ;
      P00V22_A863F1357LDGTipReg = new String[] {""} ;
      A863F1357LDGTipReg = "" ;
      AV21Option = "" ;
      P00V23_A6LegNumero = new int[1] ;
      P00V23_A3CliCod = new int[1] ;
      P00V23_A1EmpCod = new short[1] ;
      P00V23_A784F1357CTipoPre = new byte[1] ;
      P00V23_A777F1357CPer = new String[] {""} ;
      P00V23_A778F1357CSec = new byte[1] ;
      P00V23_A825F1357LDGDescuentosLey = new String[] {""} ;
      P00V23_A826F1357LDGOtrDescuLey = new String[] {""} ;
      P00V23_A250LegIdNomApe = new String[] {""} ;
      P00V23_A863F1357LDGTipReg = new String[] {""} ;
      P00V24_A6LegNumero = new int[1] ;
      P00V24_A3CliCod = new int[1] ;
      P00V24_A1EmpCod = new short[1] ;
      P00V24_A784F1357CTipoPre = new byte[1] ;
      P00V24_A777F1357CPer = new String[] {""} ;
      P00V24_A778F1357CSec = new byte[1] ;
      P00V24_A826F1357LDGOtrDescuLey = new String[] {""} ;
      P00V24_A825F1357LDGDescuentosLey = new String[] {""} ;
      P00V24_A250LegIdNomApe = new String[] {""} ;
      P00V24_A863F1357LDGTipReg = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cabf1357legdedgenwcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00V22_A6LegNumero, P00V22_A826F1357LDGOtrDescuLey, P00V22_A825F1357LDGDescuentosLey, P00V22_A250LegIdNomApe, P00V22_A778F1357CSec, P00V22_A777F1357CPer, P00V22_A784F1357CTipoPre, P00V22_A1EmpCod, P00V22_A3CliCod, P00V22_A863F1357LDGTipReg
            }
            , new Object[] {
            P00V23_A6LegNumero, P00V23_A3CliCod, P00V23_A1EmpCod, P00V23_A784F1357CTipoPre, P00V23_A777F1357CPer, P00V23_A778F1357CSec, P00V23_A825F1357LDGDescuentosLey, P00V23_A826F1357LDGOtrDescuLey, P00V23_A250LegIdNomApe, P00V23_A863F1357LDGTipReg
            }
            , new Object[] {
            P00V24_A6LegNumero, P00V24_A3CliCod, P00V24_A1EmpCod, P00V24_A784F1357CTipoPre, P00V24_A777F1357CPer, P00V24_A778F1357CSec, P00V24_A826F1357LDGOtrDescuLey, P00V24_A825F1357LDGDescuentosLey, P00V24_A250LegIdNomApe, P00V24_A863F1357LDGTipReg
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV42F1357CTipoPre ;
   private byte AV38F1357CSec ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private short AV36EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV45GXV1 ;
   private int AV35CliCod ;
   private int AV41TFLegIdNomApe_Sels_size ;
   private int AV13TFF1357LDGDescuentosLey_Sels_size ;
   private int AV16TFF1357LDGOtrDescuLey_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV20InsertIndex ;
   private long AV29count ;
   private String AV37F1357CPer ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String A863F1357LDGTipReg ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkV23 ;
   private boolean brkV25 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV39TFLegIdNomApe_SelsJson ;
   private String AV11TFF1357LDGDescuentosLey_SelsJson ;
   private String AV14TFF1357LDGOtrDescuLey_SelsJson ;
   private String A825F1357LDGDescuentosLey ;
   private String A826F1357LDGOtrDescuLey ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV40TFLegIdNomApe ;
   private String AV12TFF1357LDGDescuentosLey ;
   private String AV15TFF1357LDGOtrDescuLey ;
   private String lV40TFLegIdNomApe ;
   private String lV12TFF1357LDGDescuentosLey ;
   private String lV15TFF1357LDGOtrDescuLey ;
   private String A250LegIdNomApe ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00V22_A6LegNumero ;
   private String[] P00V22_A826F1357LDGOtrDescuLey ;
   private String[] P00V22_A825F1357LDGDescuentosLey ;
   private String[] P00V22_A250LegIdNomApe ;
   private byte[] P00V22_A778F1357CSec ;
   private String[] P00V22_A777F1357CPer ;
   private byte[] P00V22_A784F1357CTipoPre ;
   private short[] P00V22_A1EmpCod ;
   private int[] P00V22_A3CliCod ;
   private String[] P00V22_A863F1357LDGTipReg ;
   private int[] P00V23_A6LegNumero ;
   private int[] P00V23_A3CliCod ;
   private short[] P00V23_A1EmpCod ;
   private byte[] P00V23_A784F1357CTipoPre ;
   private String[] P00V23_A777F1357CPer ;
   private byte[] P00V23_A778F1357CSec ;
   private String[] P00V23_A825F1357LDGDescuentosLey ;
   private String[] P00V23_A826F1357LDGOtrDescuLey ;
   private String[] P00V23_A250LegIdNomApe ;
   private String[] P00V23_A863F1357LDGTipReg ;
   private int[] P00V24_A6LegNumero ;
   private int[] P00V24_A3CliCod ;
   private short[] P00V24_A1EmpCod ;
   private byte[] P00V24_A784F1357CTipoPre ;
   private String[] P00V24_A777F1357CPer ;
   private byte[] P00V24_A778F1357CSec ;
   private String[] P00V24_A826F1357LDGOtrDescuLey ;
   private String[] P00V24_A825F1357LDGDescuentosLey ;
   private String[] P00V24_A250LegIdNomApe ;
   private String[] P00V24_A863F1357LDGTipReg ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV41TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV13TFF1357LDGDescuentosLey_Sels ;
   private GXSimpleCollection<String> AV16TFF1357LDGOtrDescuLey_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class f1357cabf1357legdedgenwcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00V22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV41TFLegIdNomApe_Sels ,
                                          String A825F1357LDGDescuentosLey ,
                                          GXSimpleCollection<String> AV13TFF1357LDGDescuentosLey_Sels ,
                                          String A826F1357LDGOtrDescuLey ,
                                          GXSimpleCollection<String> AV16TFF1357LDGOtrDescuLey_Sels ,
                                          int AV41TFLegIdNomApe_Sels_size ,
                                          String AV40TFLegIdNomApe ,
                                          int AV13TFF1357LDGDescuentosLey_Sels_size ,
                                          String AV12TFF1357LDGDescuentosLey ,
                                          int AV16TFF1357LDGOtrDescuLey_Sels_size ,
                                          String AV15TFF1357LDGOtrDescuLey ,
                                          int AV35CliCod ,
                                          short AV36EmpCod ,
                                          byte AV42F1357CTipoPre ,
                                          String AV37F1357CPer ,
                                          byte AV38F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.F1357LDGOtrDescuLey, T1.F1357LDGDescuentosLey, T2.LegIdNomApe, T1.F1357CSec, T1.F1357CPer, T1.F1357CTipoPre, T1.EmpCod, T1.CliCod, T1.F1357LDGTipReg" ;
      scmdbuf += " FROM (F1357LegDedGen T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV41TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( AV41TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ( AV13TFF1357LDGDescuentosLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFF1357LDGDescuentosLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGDescuentosLey) like LOWER(?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( AV13TFF1357LDGDescuentosLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFF1357LDGDescuentosLey_Sels, "T1.F1357LDGDescuentosLey IN (", ")")+")");
      }
      if ( ( AV16TFF1357LDGOtrDescuLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFF1357LDGOtrDescuLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGOtrDescuLey) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV16TFF1357LDGOtrDescuLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFF1357LDGOtrDescuLey_Sels, "T1.F1357LDGOtrDescuLey IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00V23( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV41TFLegIdNomApe_Sels ,
                                          String A825F1357LDGDescuentosLey ,
                                          GXSimpleCollection<String> AV13TFF1357LDGDescuentosLey_Sels ,
                                          String A826F1357LDGOtrDescuLey ,
                                          GXSimpleCollection<String> AV16TFF1357LDGOtrDescuLey_Sels ,
                                          int AV41TFLegIdNomApe_Sels_size ,
                                          String AV40TFLegIdNomApe ,
                                          int AV13TFF1357LDGDescuentosLey_Sels_size ,
                                          String AV12TFF1357LDGDescuentosLey ,
                                          int AV16TFF1357LDGOtrDescuLey_Sels_size ,
                                          String AV15TFF1357LDGOtrDescuLey ,
                                          int AV35CliCod ,
                                          short AV36EmpCod ,
                                          byte AV42F1357CTipoPre ,
                                          String AV37F1357CPer ,
                                          byte AV38F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[8];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGDescuentosLey, T1.F1357LDGOtrDescuLey, T2.LegIdNomApe, T1.F1357LDGTipReg" ;
      scmdbuf += " FROM (F1357LegDedGen T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV41TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( AV41TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ( AV13TFF1357LDGDescuentosLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFF1357LDGDescuentosLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGDescuentosLey) like LOWER(?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( AV13TFF1357LDGDescuentosLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFF1357LDGDescuentosLey_Sels, "T1.F1357LDGDescuentosLey IN (", ")")+")");
      }
      if ( ( AV16TFF1357LDGOtrDescuLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFF1357LDGOtrDescuLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGOtrDescuLey) like LOWER(?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( AV16TFF1357LDGOtrDescuLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFF1357LDGOtrDescuLey_Sels, "T1.F1357LDGOtrDescuLey IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGDescuentosLey" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00V24( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV41TFLegIdNomApe_Sels ,
                                          String A825F1357LDGDescuentosLey ,
                                          GXSimpleCollection<String> AV13TFF1357LDGDescuentosLey_Sels ,
                                          String A826F1357LDGOtrDescuLey ,
                                          GXSimpleCollection<String> AV16TFF1357LDGOtrDescuLey_Sels ,
                                          int AV41TFLegIdNomApe_Sels_size ,
                                          String AV40TFLegIdNomApe ,
                                          int AV13TFF1357LDGDescuentosLey_Sels_size ,
                                          String AV12TFF1357LDGDescuentosLey ,
                                          int AV16TFF1357LDGOtrDescuLey_Sels_size ,
                                          String AV15TFF1357LDGOtrDescuLey ,
                                          int AV35CliCod ,
                                          short AV36EmpCod ,
                                          byte AV42F1357CTipoPre ,
                                          String AV37F1357CPer ,
                                          byte AV38F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[8];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrDescuLey, T1.F1357LDGDescuentosLey, T2.LegIdNomApe, T1.F1357LDGTipReg" ;
      scmdbuf += " FROM (F1357LegDedGen T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV41TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV41TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ( AV13TFF1357LDGDescuentosLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFF1357LDGDescuentosLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGDescuentosLey) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV13TFF1357LDGDescuentosLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFF1357LDGDescuentosLey_Sels, "T1.F1357LDGDescuentosLey IN (", ")")+")");
      }
      if ( ( AV16TFF1357LDGOtrDescuLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFF1357LDGOtrDescuLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGOtrDescuLey) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV16TFF1357LDGOtrDescuLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFF1357LDGOtrDescuLey_Sels, "T1.F1357LDGOtrDescuLey IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrDescuLey" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P00V22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).byteValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).byteValue() );
            case 1 :
                  return conditional_P00V23(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).byteValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).byteValue() );
            case 2 :
                  return conditional_P00V24(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).byteValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00V22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00V23", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00V24", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
      }
   }

}

