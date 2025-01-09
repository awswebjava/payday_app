package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_variables_sdt_variablesItem extends GxUserType
{
   public Sdtsdt_variables_sdt_variablesItem( )
   {
      this(  new ModelContext(Sdtsdt_variables_sdt_variablesItem.class));
   }

   public Sdtsdt_variables_sdt_variablesItem( ModelContext context )
   {
      super( context, "Sdtsdt_variables_sdt_variablesItem");
   }

   public Sdtsdt_variables_sdt_variablesItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_variables_sdt_variablesItem");
   }

   public Sdtsdt_variables_sdt_variablesItem( StructSdtsdt_variables_sdt_variablesItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliCodFormula") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliDescrip") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliIdMay") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliId") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliEsCant") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliAliEs") )
            {
               gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdt_variables.sdt_variablesItem" ;
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
      oWriter.writeElement("OpeCliCodFormula", gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliDescrip", gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliIdMay", gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliId", gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliEsCant", GXutil.booltostr( gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OpeCliAliEs", GXutil.booltostr( gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("OpeCliCodFormula", gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula, false, false);
      AddObjectProperty("OpeCliDescrip", gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip, false, false);
      AddObjectProperty("OpeCliIdMay", gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay, false, false);
      AddObjectProperty("OpeCliId", gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid, false, false);
      AddObjectProperty("OpeCliEsCant", gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant, false, false);
      AddObjectProperty("OpeCliAliEs", gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies, false, false);
   }

   public String getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula = value ;
   }

   public String getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip = value ;
   }

   public String getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay = value ;
   }

   public String getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid = value ;
   }

   public boolean getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant( boolean value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant = value ;
   }

   public boolean getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies ;
   }

   public void setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies( boolean value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(1) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_N ;
   }

   public web.Sdtsdt_variables_sdt_variablesItem Clone( )
   {
      return (web.Sdtsdt_variables_sdt_variablesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_variables_sdt_variablesItem struct )
   {
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula(struct.getOpeclicodformula());
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip(struct.getOpeclidescrip());
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay(struct.getOpecliidmay());
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid(struct.getOpecliid());
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant(struct.getOpecliescant());
      setgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies(struct.getOpeclialies());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_variables_sdt_variablesItem getStruct( )
   {
      web.StructSdtsdt_variables_sdt_variablesItem struct = new web.StructSdtsdt_variables_sdt_variablesItem ();
      struct.setOpeclicodformula(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula());
      struct.setOpeclidescrip(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip());
      struct.setOpecliidmay(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay());
      struct.setOpecliid(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid());
      struct.setOpecliescant(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant());
      struct.setOpeclialies(getgxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_variables_sdt_variablesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant ;
   protected boolean gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip ;
}

