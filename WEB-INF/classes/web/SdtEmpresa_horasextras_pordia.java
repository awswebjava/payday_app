package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_horasextras_pordia extends GxSilentTrnSdt
{
   public SdtEmpresa_horasextras_pordia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_horasextras_pordia.class));
   }

   public SdtEmpresa_horasextras_pordia( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_horasextras_pordia");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_horasextras_pordia( int remoteHandle ,
                                         StructSdtEmpresa_horasextras_pordia struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_horasextras_pordia( )
   {
      super( new ModelContext(SdtEmpresa_horasextras_pordia.class), "SdtEmpresa_horasextras_pordia");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EmpHsExSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "horasextras_pordia");
      metadata.set("BT", "Empresahorasextras_pordia");
      metadata.set("PK", "[ \"EmpHsExSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"PaiTipoTraId\" ],\"FKMap\":[ \"EmpHsPDiaTipTra-PaiTipoTraId\" ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsExSec") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaTipTra") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaDia") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaDesde") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaPDia") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarfaPDRec") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsExSec_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaTipTra_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaDia_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaDesde_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaPDia_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarfaPDRec_Z") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsPDiaDesde_N") )
            {
               gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Empresa.horasextras_pordia" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("EmpHsExSec", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsPDiaTipTra", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsPDiaDia", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsPDiaDesde", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTarifaPDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTarfaPDRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_horasextras_pordia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsExSec_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsPDiaTipTra_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsPDiaDia_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsPDiaDesde_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTarifaPDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTarfaPDRec_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsPDiaDesde_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("EmpHsExSec", gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec, false, includeNonInitialized);
      AddObjectProperty("EmpHsPDiaTipTra", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra, false, includeNonInitialized);
      AddObjectProperty("EmpHsPDiaDia", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia, false, includeNonInitialized);
      AddObjectProperty("EmpHsPDiaDesde", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde, false, includeNonInitialized);
      AddObjectProperty("EmpHsPDiaDesde_N", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N, false, includeNonInitialized);
      AddObjectProperty("EmpTarifaPDia", gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia, false, includeNonInitialized);
      AddObjectProperty("EmpTarfaPDRec", gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_horasextras_pordia_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_horasextras_pordia_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_horasextras_pordia_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpHsExSec_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsPDiaTipTra_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsPDiaDia_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsPDiaDesde_Z", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTarifaPDia_Z", gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTarfaPDRec_Z", gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsPDiaDesde_N", gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_horasextras_pordia sdt )
   {
      if ( sdt.IsDirty("EmpHsExSec") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec() ;
      }
      if ( sdt.IsDirty("EmpHsPDiaTipTra") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra() ;
      }
      if ( sdt.IsDirty("EmpHsPDiaDia") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia() ;
      }
      if ( sdt.IsDirty("EmpHsPDiaDesde") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N() ;
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde() ;
      }
      if ( sdt.IsDirty("EmpTarifaPDia") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia() ;
      }
      if ( sdt.IsDirty("EmpTarfaPDRec") )
      {
         gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec = sdt.getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec() ;
      }
   }

   public short getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec( short value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphsexsec");
      gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec = value ;
   }

   public String getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra( String value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiatiptra");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra = value ;
   }

   public byte getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia( byte value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiadia");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia = value ;
   }

   public String getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde( String value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiadesde");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = (byte)(1) ;
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde = "" ;
      SetDirty("Emphspdiadesde");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_IsNull( )
   {
      return (gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emptarifapdia");
      gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emptarfapdrec");
      gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec = value ;
   }

   public String getgxTv_SdtEmpresa_horasextras_pordia_Mode( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Mode ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Mode( String value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_horasextras_pordia_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_horasextras_pordia_Modified( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Modified ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Modified( short value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_horasextras_pordia_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_horasextras_pordia_Initialized( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Initialized ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Initialized( short value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_horasextras_pordia_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z( short value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphsexsec_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z = (short)(0) ;
      SetDirty("Emphsexsec_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z( String value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiatiptra_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z = "" ;
      SetDirty("Emphspdiatiptra_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z( byte value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiadia_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z = (byte)(0) ;
      SetDirty("Emphspdiadia_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z( String value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiadesde_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z = "" ;
      SetDirty("Emphspdiadesde_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emptarifapdia_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z = DecimalUtil.ZERO ;
      SetDirty("Emptarifapdia_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emptarfapdrec_Z");
      gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z = DecimalUtil.ZERO ;
      SetDirty("Emptarfapdrec_Z");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N( byte value )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtEmpresa_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Emphspdiadesde_N");
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = value ;
   }

   public void setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N_SetNull( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N = (byte)(0) ;
      SetDirty("Emphspdiadesde_N");
   }

   public boolean getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_horasextras_pordia_N = (byte)(1) ;
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra = "" ;
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde = "" ;
      gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_horasextras_pordia_Mode = "" ;
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z = "" ;
      gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z = "" ;
      gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_horasextras_pordia_N ;
   }

   public web.SdtEmpresa_horasextras_pordia Clone( )
   {
      return (web.SdtEmpresa_horasextras_pordia)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_horasextras_pordia struct )
   {
      setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec(struct.getEmphsexsec());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra(struct.getEmphspdiatiptra());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia(struct.getEmphspdiadia());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde(struct.getEmphspdiadesde());
      setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia(struct.getEmptarifapdia());
      setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec(struct.getEmptarfapdrec());
      setgxTv_SdtEmpresa_horasextras_pordia_Mode(struct.getMode());
      setgxTv_SdtEmpresa_horasextras_pordia_Modified(struct.getModified());
      setgxTv_SdtEmpresa_horasextras_pordia_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z(struct.getEmphsexsec_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z(struct.getEmphspdiatiptra_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z(struct.getEmphspdiadia_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z(struct.getEmphspdiadesde_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z(struct.getEmptarifapdia_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z(struct.getEmptarfapdrec_Z());
      setgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N(struct.getEmphspdiadesde_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_horasextras_pordia getStruct( )
   {
      web.StructSdtEmpresa_horasextras_pordia struct = new web.StructSdtEmpresa_horasextras_pordia ();
      struct.setEmphsexsec(getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec());
      struct.setEmphspdiatiptra(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra());
      struct.setEmphspdiadia(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia());
      struct.setEmphspdiadesde(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde());
      struct.setEmptarifapdia(getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia());
      struct.setEmptarfapdrec(getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec());
      struct.setMode(getgxTv_SdtEmpresa_horasextras_pordia_Mode());
      struct.setModified(getgxTv_SdtEmpresa_horasextras_pordia_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_horasextras_pordia_Initialized());
      struct.setEmphsexsec_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z());
      struct.setEmphspdiatiptra_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z());
      struct.setEmphspdiadia_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z());
      struct.setEmphspdiadesde_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z());
      struct.setEmptarifapdia_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z());
      struct.setEmptarfapdrec_Z(getgxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z());
      struct.setEmphspdiadesde_N(getgxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_horasextras_pordia_N ;
   private byte gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia ;
   private byte gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadia_Z ;
   private byte gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_N ;
   private short gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec ;
   private short gxTv_SdtEmpresa_horasextras_pordia_Modified ;
   private short gxTv_SdtEmpresa_horasextras_pordia_Initialized ;
   private short gxTv_SdtEmpresa_horasextras_pordia_Emphsexsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia ;
   private java.math.BigDecimal gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec ;
   private java.math.BigDecimal gxTv_SdtEmpresa_horasextras_pordia_Emptarifapdia_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_horasextras_pordia_Emptarfapdrec_Z ;
   private String gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra ;
   private String gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde ;
   private String gxTv_SdtEmpresa_horasextras_pordia_Mode ;
   private String gxTv_SdtEmpresa_horasextras_pordia_Emphspdiatiptra_Z ;
   private String gxTv_SdtEmpresa_horasextras_pordia_Emphspdiadesde_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

