package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem extends GxUserType
{
   public Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem( )
   {
      this(  new ModelContext(Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem.class));
   }

   public Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem( ModelContext context )
   {
      super( context, "Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem( StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConConvePaiCod") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConConveCodigo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo = oReader.getValue() ;
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
         sName = "sdt_concepto.sdt_conceptoItem.ConveniosItem" ;
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
      oWriter.writeElement("ConConvePaiCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConConveCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("ConConvePaiCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod, false, false);
      AddObjectProperty("ConConveCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo, false, false);
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N ;
   }

   public web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem Clone( )
   {
      return (web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem struct )
   {
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod(struct.getConconvepaicod());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo(struct.getConconvecodigo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem getStruct( )
   {
      web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem struct = new web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem ();
      struct.setConconvepaicod(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod());
      struct.setConconvecodigo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

