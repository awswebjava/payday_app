package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_horasextras_pordia extends GxSilentTrnSdt
{
   public SdtPais_horasextras_pordia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_horasextras_pordia.class));
   }

   public SdtPais_horasextras_pordia( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_horasextras_pordia");
      initialize( remoteHandle) ;
   }

   public SdtPais_horasextras_pordia( int remoteHandle ,
                                      StructSdtPais_horasextras_pordia struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_horasextras_pordia( )
   {
      super( new ModelContext(SdtPais_horasextras_pordia.class), "SdtPais_horasextras_pordia");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiHsExSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "horasextras_pordia");
      metadata.set("BT", "Paishorasextras_pordia");
      metadata.set("PK", "[ \"PaiHsExSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\",\"PaiTipoTraId\" ],\"FKMap\":[ \"PaiHsPDiaTipTra-PaiTipoTraId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsExSec") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihsexsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaTipTra") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDia") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiadia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDesde") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDia") )
            {
               gxTv_SdtPais_horasextras_pordia_Paitarifapdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDRec") )
            {
               gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_horasextras_pordia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_horasextras_pordia_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_horasextras_pordia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsExSec_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaTipTra_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDia_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDesde_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDia_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTarifaPDRec_Z") )
            {
               gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiHsPDiaDesde_N") )
            {
               gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Pais.horasextras_pordia" ;
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
      oWriter.writeElement("PaiHsExSec", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Paihsexsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiHsPDiaTipTra", gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiHsPDiaDia", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Paihspdiadia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiHsPDiaDesde", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTarifaPDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_horasextras_pordia_Paitarifapdia, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTarifaPDRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_horasextras_pordia_Paitarifapdrec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_horasextras_pordia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiHsExSec_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiHsPDiaTipTra_Z", gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiHsPDiaDia_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiHsPDiaDesde_Z", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTarifaPDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTarifaPDRec_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiHsPDiaDesde_N", GXutil.trim( GXutil.str( gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N, 1, 0)));
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
      AddObjectProperty("PaiHsExSec", gxTv_SdtPais_horasextras_pordia_Paihsexsec, false, includeNonInitialized);
      AddObjectProperty("PaiHsPDiaTipTra", gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra, false, includeNonInitialized);
      AddObjectProperty("PaiHsPDiaDia", gxTv_SdtPais_horasextras_pordia_Paihspdiadia, false, includeNonInitialized);
      AddObjectProperty("PaiHsPDiaDesde", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde, false, includeNonInitialized);
      AddObjectProperty("PaiHsPDiaDesde_N", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N, false, includeNonInitialized);
      AddObjectProperty("PaiTarifaPDia", gxTv_SdtPais_horasextras_pordia_Paitarifapdia, false, includeNonInitialized);
      AddObjectProperty("PaiTarifaPDRec", gxTv_SdtPais_horasextras_pordia_Paitarifapdrec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_horasextras_pordia_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_horasextras_pordia_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_horasextras_pordia_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiHsExSec_Z", gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z, false, includeNonInitialized);
         AddObjectProperty("PaiHsPDiaTipTra_Z", gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z, false, includeNonInitialized);
         AddObjectProperty("PaiHsPDiaDia_Z", gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z, false, includeNonInitialized);
         AddObjectProperty("PaiHsPDiaDesde_Z", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTarifaPDia_Z", gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTarifaPDRec_Z", gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z, false, includeNonInitialized);
         AddObjectProperty("PaiHsPDiaDesde_N", gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_horasextras_pordia sdt )
   {
      if ( sdt.IsDirty("PaiHsExSec") )
      {
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paihsexsec = sdt.getgxTv_SdtPais_horasextras_pordia_Paihsexsec() ;
      }
      if ( sdt.IsDirty("PaiHsPDiaTipTra") )
      {
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = sdt.getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra() ;
      }
      if ( sdt.IsDirty("PaiHsPDiaDia") )
      {
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paihspdiadia = sdt.getgxTv_SdtPais_horasextras_pordia_Paihspdiadia() ;
      }
      if ( sdt.IsDirty("PaiHsPDiaDesde") )
      {
         gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = sdt.getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N() ;
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = sdt.getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde() ;
      }
      if ( sdt.IsDirty("PaiTarifaPDia") )
      {
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paitarifapdia = sdt.getgxTv_SdtPais_horasextras_pordia_Paitarifapdia() ;
      }
      if ( sdt.IsDirty("PaiTarifaPDRec") )
      {
         gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
         gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = sdt.getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec() ;
      }
   }

   public short getgxTv_SdtPais_horasextras_pordia_Paihsexsec( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihsexsec ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihsexsec( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihsexsec");
      gxTv_SdtPais_horasextras_pordia_Paihsexsec = value ;
   }

   public String getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiatiptra");
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = value ;
   }

   public byte getgxTv_SdtPais_horasextras_pordia_Paihspdiadia( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadia ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadia( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiadia");
      gxTv_SdtPais_horasextras_pordia_Paihspdiadia = value ;
   }

   public String getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde( String value )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiadesde");
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(1) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = "" ;
      SetDirty("Paihspdiadesde");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_IsNull( )
   {
      return (gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_horasextras_pordia_Paitarifapdia( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdia ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paitarifapdia");
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdrec ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paitarifapdrec");
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = value ;
   }

   public String getgxTv_SdtPais_horasextras_pordia_Mode( )
   {
      return gxTv_SdtPais_horasextras_pordia_Mode ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Mode( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_horasextras_pordia_Mode = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Mode_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_horasextras_pordia_Modified( )
   {
      return gxTv_SdtPais_horasextras_pordia_Modified ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Modified( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_horasextras_pordia_Modified = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Modified_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_horasextras_pordia_Initialized( )
   {
      return gxTv_SdtPais_horasextras_pordia_Initialized ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Initialized( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_horasextras_pordia_Initialized = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Initialized_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z( short value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihsexsec_Z");
      gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z = (short)(0) ;
      SetDirty("Paihsexsec_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiatiptra_Z");
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = "" ;
      SetDirty("Paihspdiatiptra_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiadia_Z");
      gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z = (byte)(0) ;
      SetDirty("Paihspdiadia_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z( String value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiadesde_Z");
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = "" ;
      SetDirty("Paihspdiadesde_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paitarifapdia_Z");
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = DecimalUtil.ZERO ;
      SetDirty("Paitarifapdia_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paitarifapdrec_Z");
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = DecimalUtil.ZERO ;
      SetDirty("Paitarifapdrec_Z");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N( )
   {
      return gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N( byte value )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(0) ;
      gxTv_SdtPais_horasextras_pordia_Modified = (short)(1) ;
      SetDirty("Paihspdiadesde_N");
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = value ;
   }

   public void setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N_SetNull( )
   {
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N = (byte)(0) ;
      SetDirty("Paihspdiadesde_N");
   }

   public boolean getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_horasextras_pordia_N = (byte)(1) ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde = "" ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia = DecimalUtil.ZERO ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec = DecimalUtil.ZERO ;
      gxTv_SdtPais_horasextras_pordia_Mode = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z = "" ;
      gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z = "" ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_horasextras_pordia_N ;
   }

   public web.SdtPais_horasextras_pordia Clone( )
   {
      return (web.SdtPais_horasextras_pordia)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_horasextras_pordia struct )
   {
      setgxTv_SdtPais_horasextras_pordia_Paihsexsec(struct.getPaihsexsec());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra(struct.getPaihspdiatiptra());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiadia(struct.getPaihspdiadia());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde(struct.getPaihspdiadesde());
      setgxTv_SdtPais_horasextras_pordia_Paitarifapdia(struct.getPaitarifapdia());
      setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec(struct.getPaitarifapdrec());
      setgxTv_SdtPais_horasextras_pordia_Mode(struct.getMode());
      setgxTv_SdtPais_horasextras_pordia_Modified(struct.getModified());
      setgxTv_SdtPais_horasextras_pordia_Initialized(struct.getInitialized());
      setgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z(struct.getPaihsexsec_Z());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z(struct.getPaihspdiatiptra_Z());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z(struct.getPaihspdiadia_Z());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z(struct.getPaihspdiadesde_Z());
      setgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z(struct.getPaitarifapdia_Z());
      setgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z(struct.getPaitarifapdrec_Z());
      setgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N(struct.getPaihspdiadesde_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_horasextras_pordia getStruct( )
   {
      web.StructSdtPais_horasextras_pordia struct = new web.StructSdtPais_horasextras_pordia ();
      struct.setPaihsexsec(getgxTv_SdtPais_horasextras_pordia_Paihsexsec());
      struct.setPaihspdiatiptra(getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra());
      struct.setPaihspdiadia(getgxTv_SdtPais_horasextras_pordia_Paihspdiadia());
      struct.setPaihspdiadesde(getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde());
      struct.setPaitarifapdia(getgxTv_SdtPais_horasextras_pordia_Paitarifapdia());
      struct.setPaitarifapdrec(getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec());
      struct.setMode(getgxTv_SdtPais_horasextras_pordia_Mode());
      struct.setModified(getgxTv_SdtPais_horasextras_pordia_Modified());
      struct.setInitialized(getgxTv_SdtPais_horasextras_pordia_Initialized());
      struct.setPaihsexsec_Z(getgxTv_SdtPais_horasextras_pordia_Paihsexsec_Z());
      struct.setPaihspdiatiptra_Z(getgxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z());
      struct.setPaihspdiadia_Z(getgxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z());
      struct.setPaihspdiadesde_Z(getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z());
      struct.setPaitarifapdia_Z(getgxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z());
      struct.setPaitarifapdrec_Z(getgxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z());
      struct.setPaihspdiadesde_N(getgxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N());
      return struct ;
   }

   private byte gxTv_SdtPais_horasextras_pordia_N ;
   private byte gxTv_SdtPais_horasextras_pordia_Paihspdiadia ;
   private byte gxTv_SdtPais_horasextras_pordia_Paihspdiadia_Z ;
   private byte gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_N ;
   private short gxTv_SdtPais_horasextras_pordia_Paihsexsec ;
   private short gxTv_SdtPais_horasextras_pordia_Modified ;
   private short gxTv_SdtPais_horasextras_pordia_Initialized ;
   private short gxTv_SdtPais_horasextras_pordia_Paihsexsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdia ;
   private java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdrec ;
   private java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdia_Z ;
   private java.math.BigDecimal gxTv_SdtPais_horasextras_pordia_Paitarifapdrec_Z ;
   private String gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra ;
   private String gxTv_SdtPais_horasextras_pordia_Paihspdiadesde ;
   private String gxTv_SdtPais_horasextras_pordia_Mode ;
   private String gxTv_SdtPais_horasextras_pordia_Paihspdiatiptra_Z ;
   private String gxTv_SdtPais_horasextras_pordia_Paihspdiadesde_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

